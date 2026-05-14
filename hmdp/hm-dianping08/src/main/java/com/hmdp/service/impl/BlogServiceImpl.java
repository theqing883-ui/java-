package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.dto.ScrollResult;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.Blog;
import com.hmdp.entity.Follow;
import com.hmdp.entity.User;
import com.hmdp.mapper.BlogMapper;
import com.hmdp.service.IBlogService;
import com.hmdp.service.IFollowService;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.UserHolder;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {
    @Resource
    private IUserService userService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private IFollowService followService;

    @Override
    public Result queryHotBlog(Integer current) {
        // 根据用户查询
        Page<Blog> page = query().orderByDesc("liked").page(new Page<>(current, SystemConstants.MAX_PAGE_SIZE));
        // 获取当前页数据
        List<Blog> records = page.getRecords();
        // 查询用户
        records.forEach(blog -> {
            this.blogWithUser(blog);
            this.isBlogLiked(blog);
        });
        //查询当前用户是否为博客点赞
        return Result.ok(records);
    }

    @Override
    public Result queryBlogById(Long id) {
        //查询博客信息
        Blog blog = getById(id);
        //查询博客用户
        blogWithUser(blog);
        //查询当前用户是否为博客点赞
        isBlogLiked(blog);
        return Result.ok(blog);
    }

    private void isBlogLiked(Blog blog) {
        Long id = blog.getId();
        //获取当前用户
        UserDTO user = UserHolder.getUser();
        if (user == null) {
            return;
        }
        Long userId = user.getId();
        //判断当前用户是否点赞
        String key = RedisConstants.BLOG_LIKED_KEY + id;
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        blog.setIsLike(score != null);
    }

    @Override
    public Result likeBlog(Long id) {
        //获取当前用户
        Long userId = UserHolder.getUser().getId();
        //判断当前用户是否点赞
        String key = RedisConstants.BLOG_LIKED_KEY + id;
        Double score = stringRedisTemplate.opsForZSet().score(key, userId.toString());
        if (score == null) {
            // 未点赞
            boolean isSuccess = update().setSql("liked = liked + 1").eq("id", id).update();
            if (isSuccess) {
                stringRedisTemplate.opsForZSet().add(key, userId.toString(), System.currentTimeMillis());
            }
        } else {
            boolean isSuccess = update().setSql("liked = liked - 1").eq("id", id).update();
            if (isSuccess) {
                stringRedisTemplate.opsForZSet().remove(key, userId.toString());
            }
        }
        return Result.ok();
    }

    /**
     * 查询博客点赞用户列表
     * <p>
     * 从Redis中获取该博客点赞的前5名用户（按时间排序），
     * 并返回这些用户的详细信息列表。
     * </p>
     *
     * @param id 博客ID，用于构造Redis中存储点赞信息的key
     * @return Result对象，包含点赞用户的信息列表（UserDTO），如果没有用户点赞则返回空列表
     */
    @Override
    public Result queryBlogLikes(Long id) {
        String key = RedisConstants.BLOG_LIKED_KEY + id;

        // 从Redis的ZSet中获取前5个点赞用户的ID（按时间戳升序排列）
        //取出的只有value Id 没有score
        Set<String> set = stringRedisTemplate.opsForZSet().range(key, 0, 4);
        if (set == null || set.isEmpty()) {
            return Result.ok();
        }

        // 将用户ID字符串转换为Long类型列表
        List<Long> list = set.stream().map(Long::valueOf).collect(Collectors.toList());
        String idString = StrUtil.join(",", list);

        // 批量查询用户信息并转换为UserDTO对象,自定义顺序
        List<UserDTO> userDTOS = userService.query().in("id", list).last("ORDER BY FIELD( id," + idString + ")").list()
                .stream().map(user -> BeanUtil.copyProperties(user, UserDTO.class))
                .collect(Collectors.toList());
        return Result.ok(userDTOS);
    }

    @Override
    public Result saveBlog(Blog blog) {
        //1 获取登录用户
        UserDTO user = UserHolder.getUser();
        blog.setUserId(user.getId());

        //2 保存探店博文
        boolean isSuccess = save(blog);
        if (!isSuccess) {
            return Result.fail("发布失败！");
        }
        //3 查询博主粉丝并推送 创建收件箱
        List<Follow> follows = followService.query().eq("follow_user_id", user.getId()).list();
        if (follows == null || follows.isEmpty()) {
            //没有粉丝
//            log.error("没有粉丝！");
            return Result.ok(blog.getId());
        }
        //有粉丝
        for (Follow follow : follows) {
            Long userId = follow.getUserId();
            String key = RedisConstants.FEED_KEY + userId;
            // 推送
            stringRedisTemplate.opsForZSet().
                    add(key, blog.getId().toString(), System.currentTimeMillis());
        }
        //4 返回id
        return Result.ok(blog.getId());
    }

    @Override
    public Result queryBlogOfFollow(Long time, Integer offset) {
//        log.error("进入方法！");
        // 查询当前用户的收件箱
        Long userId = UserHolder.getUser().getId();
        String key = RedisConstants.FEED_KEY + userId;
        Set<ZSetOperations.TypedTuple<String>> typedTuples = stringRedisTemplate.opsForZSet().
                reverseRangeByScoreWithScores(key, 0, time, offset, 2);
        if (typedTuples == null || typedTuples.isEmpty()) {
            log.error("收件箱为空！");
            return Result.ok();
        }
        ArrayList<Blog> blogs = new ArrayList<>(typedTuples.size());
        long minTime = 0;//最小值默认为0
        int os = 1;//至少自己与自己相等
        //遍历收件箱
        for (ZSetOperations.TypedTuple<String> typedTuple : typedTuples) {
            //非空typedTuple
            blogs.add(getById(Long.valueOf(Objects.requireNonNull(typedTuple.getValue()))));
            long timeTemp = Objects.requireNonNull(typedTuple.getScore()).longValue();
            if (minTime == timeTemp) {
                os++;
            } else {//后面遍历的时间戳肯定比前面小
                minTime = timeTemp;
                os = 1;
            }
        }
        for (Blog blog : blogs) {
            //查询博客用户
            blogWithUser(blog);
            //查询当前用户是否为博客点赞
            isBlogLiked(blog);
        }
        //封装结果
        ScrollResult scrollResult = new ScrollResult();
        scrollResult.setList(blogs);
        scrollResult.setOffset(os);
        scrollResult.setMinTime(minTime);
        return Result.ok(scrollResult);
    }

    private void blogWithUser(Blog blog) {
        Long userId = blog.getUserId();
        User user = userService.getById(userId);
        blog.setName(user.getNickName());
        blog.setIcon(user.getIcon());
    }
}

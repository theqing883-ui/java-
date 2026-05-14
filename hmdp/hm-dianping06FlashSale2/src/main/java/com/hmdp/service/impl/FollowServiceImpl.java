package com.hmdp.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.Follow;
import com.hmdp.mapper.FollowMapper;
import com.hmdp.service.IFollowService;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Resource
    IUserService userService;

    @Override
    public Result follow(Long followUserId, Boolean isFollow) {
        UserDTO user = UserHolder.getUser();
        if (user == null) {
            return Result.fail("请先登录！");
        }
        Long userId = user.getId();
        String key = "follows:"+userId;
        if (isFollow) {
            //关注
            Follow follow = new Follow();
            follow.setFollowUserId(followUserId);
            follow.setUserId(userId);
            boolean isSuccess = save(follow);
            //添加数据库数据
            if (isSuccess){
                stringRedisTemplate.opsForSet().add(key,followUserId.toString());
            }
        } else {
            //取关
            /*
            remove(new QueryWrapper<Follow>()
            // 注意：这里必须写数据库里的列名，通常是下划线格式 "user_id"
            .eq("user_id", userId)
            .eq("follow_user_id", followUserId)
            );
            * */
            // 将 LambdaQueryWrapper 改为 QueryWrapper，并使用数据库列名字符串
            boolean isSuccess = remove(new QueryWrapper<Follow>()
                    .eq("user_id", userId)
                    .eq("follow_user_id", followUserId)
            );
            //移除Redis数据
            if (isSuccess){
                stringRedisTemplate.opsForSet().remove(key,followUserId.toString());
            }
        }
        return Result.ok();
    }

    @Override
    public Result isFollow(Long followUserId) {
        // 查询是否关注
        UserDTO user = UserHolder.getUser();
        if (user == null) {
            return Result.fail("请先登录！");
        }
        Long userId = user.getId();
        Integer count = query().eq("user_id", userId).eq("follow_user_id", followUserId).count();
        return Result.ok(count > 0);
    }

    /**
     * 查询共同关注用户列表
     * <p>
     * 通过Redis集合的交集运算，找出当前用户与指定用户都关注的用户列表，
     * 并返回这些共同关注用户的详细信息。
     * </p>
     *
     * @param id 目标用户ID，用于与当前用户进行共同关注比较
     * @return Result对象，包含共同关注用户的详细信息列表（UserDTO），如果没有共同关注则返回空列表
     */
    @Override
    public Result followCommons(Long id) {
        Long userId = UserHolder.getUser().getId();
        String key = "follows:" + userId;
        String key2 = "follows:" + id;
        
        // 计算当前用户与目标用户关注列表的交集，获取共同关注的用户ID
        Set<String> set = stringRedisTemplate.opsForSet().intersect(key, key2);
        if (set == null || set.isEmpty() ) {
            return Result.ok(Collections.emptyList());
        }
        
        // 将用户ID字符串转换为Long类型列表
        List<Long> list = set.stream().map(Long::valueOf).collect(Collectors.toList());
        
        // 批量查询共同关注用户的详细信息并转换为UserDTO对象
        List<UserDTO> userDTOS = userService.listByIds(list)
                .stream().map(user -> BeanUtil.copyProperties(user, UserDTO.class)).collect(Collectors.toList());
        return Result.ok(userDTOS);
    }
}

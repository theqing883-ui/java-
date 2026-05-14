package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RedisConstants;
import com.hmdp.utils.RegexUtils;
import com.hmdp.utils.SystemConstants;
import com.hmdp.utils.UserToUserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 发送验证码到指定手机号
     *
     * @param phone   用户手机号码
     * @param session HTTP 会话对象，用于存储验证码
     * @return Result 操作结果，成功返回"发送成功！"，失败返回"手机号格式错误!"
     */
    @Override
    public Result sendCode(String phone, HttpSession session) {
        // 验证手机号格式
        /**
         RegexUtils.isPhoneInvalid(phone)
         手机号合法，返回false
         手机号不合法，返回true
         * */
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("手机号格式错误!");
        }
        // 生成 6 位随机验证码并存储到 session
        String code = RandomUtil.randomNumbers(6);
        // 日志打印验证码
        log.debug("发送短信验证码成功，验证码： " + code);
        //保存 code
        // 这里用phone作为key的一部分，在做code验证时，保证取的也是这个号码phone对应的code，
        stringRedisTemplate.opsForValue().set(RedisConstants.LOGIN_CODE_KEY + phone, code, RedisConstants.LOGIN_CODE_TTL, TimeUnit.MINUTES);
        return Result.ok("发送成功！");
    }

    /**
     * 用户登录
     *
     * @param loginForm 登录表单数据，包含手机号和验证码
     * @param session   HTTP 会话对象，用于存储验证码和用户信息
     * @return Result 操作结果，成功返回空对象，失败返回相应错误信息
     */
    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        String phone = loginForm.getPhone();
        // 验证手机号格式
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("手机号格式错误!");
        }
        // 验证验证码
        String cacheCode = stringRedisTemplate.opsForValue().get(RedisConstants.LOGIN_CODE_KEY + phone);
        String code = loginForm.getCode();
        if (!(code != null && code.trim().equals(cacheCode))) {
            return Result.fail("验证码或手机号错误！");
        }
        // 删除使用过的验证码
        stringRedisTemplate.delete(RedisConstants.LOGIN_CODE_KEY + phone);
        // 查询用户是否存在
        User user = query().eq("phone", phone).one();
        // 用户不存在则创建新用户
        if (user == null) {
            user = createUserByPhone(phone);
        }
        // 将用户信息存储到 Redis
        UserDTO userDTO = UserToUserDTO.userToUserDTO(user);
        Map<String, Object> userDtOMap = BeanUtil.beanToMap(userDTO, new HashMap<>(),                      // 目标容器：新的 HashMap 接收转换结果
                CopyOptions.create()                  // 转换配置选项
                        .setIgnoreNullValue(true)         //   ├─ 忽略值为 null 的字段（不放入 Map）
                        .setFieldValueEditor(             //   └─ 字段值编辑器（自定义处理逻辑）
                                (fieldKey, fieldValue) -> //      ├─ Lambda 表达式：(字段名, 字段值)
                                        fieldValue.toString()         //       └─ 将所有值统一转为 String 类型
                        ));
        String token = UUID.randomUUID().toString();
        stringRedisTemplate.opsForHash().putAll(RedisConstants.LOGIN_USER_KEY + token, userDtOMap);
        //设置有效期 这个有效期是指用户超过这个时间不访问这个网页，用户信息将会从Redis里面删除，用户需要重新登陆
        stringRedisTemplate.expire(RedisConstants.LOGIN_USER_KEY + token, RedisConstants.LOGIN_USER_TTL, TimeUnit.MINUTES);
        return Result.ok(token);
    }
    /**
     * 根据手机号创建新用户
     *
     * @param phone 用户手机号码
     * @return User 创建的用户对象
     */
    private User createUserByPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        // 设置随机昵称
        user.setNickName(SystemConstants.USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        // 保存用户到数据库
        save(user);
        return user;
    }
}

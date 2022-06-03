package com.liyeam.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liyeam.seckill.entity.TUser;
import com.liyeam.seckill.exception.GlobalException;
import com.liyeam.seckill.mapper.TUserMapper;
import com.liyeam.seckill.service.ITUserService;
import com.liyeam.seckill.utils.CookieUtil;
import com.liyeam.seckill.utils.MD5Util;
import com.liyeam.seckill.utils.UUIDUtil;
import com.liyeam.seckill.vo.LoginVo;
import com.liyeam.seckill.vo.RespBean;
import com.liyeam.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liyeam
 * @since 2022-06-03
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    TUserMapper userMapper;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public RespBean doLogin(LoginVo vo, HttpServletRequest request, HttpServletResponse response) {
        String mobile = vo.getMobile();
        String password = vo.getPassword();
        TUser tUser = userMapper.selectById(mobile);
        // 根据手机号获取用户
        if (tUser == null) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        // 判断密码是否正确
        if (!tUser.getPassword().equals(MD5Util.formPassToDBPass(password, tUser.getSlat()))) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        // 生成cookie
        String ticket = UUIDUtil.uuid();
        // 验证成功将用户数据缓存在redis中
        redisTemplate.opsForValue().set("user:" + ticket, tUser);
        CookieUtil.setCookie(request, response, "userTicket", ticket, -1, true);
        return RespBean.success(RespBeanEnum.SUCCESS);
    }

    @Override
    public TUser getUserByCookie(String userTicket, HttpServletRequest request, HttpServletResponse response) {
        if (StringUtils.isEmpty(userTicket)) {
            return null;
        }
        TUser user = (TUser) redisTemplate.opsForValue().get("user:" + userTicket);
        if (user != null) {
            CookieUtil.setCookie(request, response, "userTicket", userTicket, -1, true);
        }
        return user;
    }
}

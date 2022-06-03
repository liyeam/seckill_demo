package com.liyeam.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liyeam.seckill.entity.TUser;
import com.liyeam.seckill.mapper.TUserMapper;
import com.liyeam.seckill.service.ITUserService;
import com.liyeam.seckill.utils.MD5Util;
import com.liyeam.seckill.utils.ValidatorUtil;
import com.liyeam.seckill.vo.LoginVo;
import com.liyeam.seckill.vo.RespBean;
import com.liyeam.seckill.vo.RespBeanEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liyeam
 * @since 2022-06-03
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

    @Autowired
    TUserMapper userMapper;

    @Override
    public RespBean doLogin(LoginVo vo) {
        String mobile = vo.getMobile();
        String password = vo.getPassword();
        if (mobile == null || password == null) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        if (!ValidatorUtil.isMobile(mobile)) {
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);
        }
        TUser tUser = userMapper.selectById(mobile);

        if (tUser == null) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
        System.out.println(tUser.getPassword());
        if (!tUser.getPassword().equals(MD5Util.formPassToDBPass(password,tUser.getSlat()))) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }

        return RespBean.success(RespBeanEnum.SUCCESS);
    }
}

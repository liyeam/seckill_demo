package com.liyeam.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liyeam.seckill.entity.TUser;
import com.liyeam.seckill.vo.LoginVo;
import com.liyeam.seckill.vo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liyeam
 * @since 2022-06-03
 */
public interface ITUserService extends IService<TUser> {

    RespBean doLogin(LoginVo vo);
}

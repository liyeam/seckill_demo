package com.liyeam.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liyeam.seckill.entity.TUser;
import com.liyeam.seckill.vo.LoginVo;
import com.liyeam.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liyeam
 * @since 2022-06-03
 */
public interface ITUserService extends IService<TUser> {

    /**
     * 验证用户信息
     * @param vo
     * @param request
     * @param response
     * @return
     */
    RespBean doLogin(LoginVo vo, HttpServletRequest request, HttpServletResponse response);

    /**
     * 根据Cookie，查看缓存是否有用户信息
     * @param userTicket
     * @param request
     * @param response
     * @return
     */
    TUser getUserByCookie(String userTicket,HttpServletRequest request, HttpServletResponse response);
}

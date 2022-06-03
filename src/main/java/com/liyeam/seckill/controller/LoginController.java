package com.liyeam.seckill.controller;

import com.liyeam.seckill.service.ITUserService;
import com.liyeam.seckill.vo.LoginVo;
import com.liyeam.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    ITUserService service;
    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = {"/","/index",""})
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(LoginVo vo){
        RespBean respBean = service.doLogin(vo);
        log.info("接收到数据：{}",vo);
        return respBean;
    }
}

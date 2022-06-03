package com.liyeam.seckill.controller;

import com.liyeam.seckill.entity.TUser;
import com.liyeam.seckill.service.ITUserService;
import com.liyeam.seckill.service.impl.TUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liyeam
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private ITUserService userService;

    @RequestMapping("/goodsList")
    public String toList(@CookieValue("userTicket") String ticket, Model model, HttpServletRequest request, HttpServletResponse response) {
        TUser user;
        if (StringUtils.isEmpty(ticket) || (user = userService.getUserByCookie(ticket,request,response)) == null) {
            return "login";
        }
        model.addAttribute("user",user);
        return "goods_list";
    }
}

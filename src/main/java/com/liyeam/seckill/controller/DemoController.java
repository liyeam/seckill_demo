package com.liyeam.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/test")
    public String testDemo(Model model){
        model.addAttribute("name","zhangsan");
        return "hello";
    }
}

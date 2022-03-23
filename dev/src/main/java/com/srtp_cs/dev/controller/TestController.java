package com.srtp_cs.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping({"/","/index"})
    public String index() {
        return "/index";
    }

    @RequestMapping("/login_register")
    public String login() {
        return "/login_register";
    }

}

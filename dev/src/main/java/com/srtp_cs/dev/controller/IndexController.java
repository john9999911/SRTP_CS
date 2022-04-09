package com.srtp_cs.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("msg", null);
        if (!model.containsAttribute("username")) {
            model.addAttribute("username", null);
        }
        return "/index";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin";
    }
}

package com.srtp_cs.dev.controller.User;

import com.srtp_cs.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String login(){
        return "/user/login_register";
    }

//    @RequestMapping("/register_completed")
//    public String RegisterCompleted(){
//
//        return "redirect:/index";
//    }

    @RequestMapping("login_completed")
    public String LoginCompleted(@RequestParam("mail") String mail, @RequestParam("password") String password, Model model){

        if(userService.login(mail,password)){
            String userName = userService.selectUserByMail(mail).getName();
            model.addAttribute("username",userName);
            return "redirect:/index";
        } else {
            model.addAttribute("msg","邮箱或密码错误");
            return "/user/login_register";
        }
    }


}

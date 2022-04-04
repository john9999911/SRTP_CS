package com.srtp_cs.dev.controller.User;

import com.srtp_cs.dev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String login() {
        return "/user/login";
    }

    //登录
    @RequestMapping("login_completed")
    public String LoginCompleted(
            @RequestParam("mail") String mail,
            @RequestParam("password") String password,
            Model model,
            HttpSession session
    ) {
        if (userService.selectUserByMail(mail) == null) {
            model.addAttribute("l_msg", "用户不存在");
        } else if (!(userService.selectUserByMail(mail).getPwd()).equals(userService.encryptPassword(password))) {
            model.addAttribute("l_msg", "密码错误");
        } else {
            session.setAttribute("loginUser", userService.selectUserByMail(mail).getName());
            return "redirect:/index";
        }
        return "/user/login";
    }

    //注册, 输入验证
    @RequestMapping("register_completed")
    public String Register(
            @RequestParam("mail") String mail,
            @RequestParam("username") String name,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            Model model,
            HttpSession session
    ) {
        if (mail.equals("") || name.equals("") || password.equals("")) {
            model.addAttribute("r_msg", "请填写完整");
            return "/user/register";
        } else if(!mail.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
            model.addAttribute("r_msg", "邮箱格式错误");
            return "/user/register";
        } else if (!password.matches("^(?=.*[a-zA-Z])(?=.*\\d).{1,9}$") || !password2.matches("^(?=.*[a-zA-Z])(?=.*\\d).{1,9}$")) {
            model.addAttribute("r_msg", "密码格式错误");
            return "/user/register";
        } else if(!password.equals(password2)){
            model.addAttribute("r_msg", "两次密码不一致");
            return "/user/register";
        } else if (userService.selectUserByMail(mail) != null) {
            model.addAttribute("r_msg", "用户已存在，请直接登录");
            return "/user/register";
        } else {
            password = userService.encryptPassword(password);
            userService.insertUser(mail, name, password);
            session.setAttribute("loginUser", name);
            return "redirect:/index";
        }
    }

    @RequestMapping("toLogout")
    public String Logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}



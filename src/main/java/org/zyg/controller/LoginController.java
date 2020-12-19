package org.zyg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zyg.domain.User;
import org.zyg.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource(name = "userService")
    private UserService userService;
    @PostMapping("/login")
    public String login(String userName, String userPass, HttpSession session, Model model) {
        User user = userService.queryUser(userName, userPass);
        if (user != null) {
            session.setAttribute("user", user);
            return "books";
        } else {
            model.addAttribute("tip", "登陆失败");
            return "loginForm";
        }

    }
    //跳转到注册页面
    @GetMapping ("/userRegis")
    public String Register() {
        return "RegisForm";
    }
    //添加用户
    @PostMapping("/addUser")
    public String addUser(String userName, String userPass, @Validated User user, BindingResult bindingResult) {
        if (bindingResult.getErrorCount() > 0)
        {
            return "RegisForm";
        } else{
            user.setUserName(userName);
            user.setUserPass(userPass);
            userService.addUser(user);
            return "loginForm";
        }

    }
}

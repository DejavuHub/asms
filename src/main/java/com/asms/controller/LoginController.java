package com.asms.controller;

import com.asms.pojo.User;
import com.asms.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/index.html")
    public String index(HttpSession session){
        session.invalidate();
        return "index";
    }
    @RequestMapping("/user/user.html")
    public String login(HttpSession session,User user){
        User loginUser=loginService.login(user);
        if(loginUser==null){
            return "redirect:/index.html";
        }
        session.setAttribute("user",loginUser);
        if(loginUser.getRole().getName().equals("学生")){
            return "student";
        }
        if(loginUser.getRole().getName().equals("老师")){
            return "teacher";
        }
        if(loginUser.getRole().getName().equals("教务管理员")){
            return "eduadmin";
        }
        return null;
    }
}

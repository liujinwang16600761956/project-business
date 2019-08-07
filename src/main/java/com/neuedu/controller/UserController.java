package com.neuedu.controller;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/")
public class UserController {


    @Autowired
    private IUserService userService;



    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public  String  login(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpServletRequest request,
                          HttpServletResponse response){


        HttpSession session=request.getSession();
        UserInfo userInfo=userService.login(username, password);


        if(userInfo!=null){//登录成功

            Cookie username_cookie=new Cookie("username",username);
            Cookie password_cookie=new Cookie("password",password);
            password_cookie.setMaxAge(60*60*24*7);
            username_cookie.setMaxAge(60*60*24*7);
            response.addCookie(username_cookie);
            response.addCookie(password_cookie);

            session.setAttribute(Const.CURRENT_USER,userInfo);
            return "redirect:admin";

        }
        return "forward:login";
    }



    @RequestMapping("/admin")
    public  String  AdminUser(HttpSession session){

        List<UserInfo> userInfos=userService.selectAdmin();
        session.setAttribute("userInfos",userInfos);
        return "userList";
    }







}

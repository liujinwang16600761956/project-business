package com.neuedu.interceptor;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Component
public class AdminInterceptor implements HandlerInterceptor {


    @Autowired
    private IUserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String username=null;
        String password=null;
        HttpSession session = request.getSession();
        Cookie[] cookies=request.getCookies();
        if(cookies==null) {
            try {
                response.sendRedirect(request.getContextPath()+"/user/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(cookies!=null&&cookies.length>0){
            for(Cookie c:cookies){

                if(c.getName().equals("username")){
                    username=c.getValue();
                }
                if(c.getName().equals("password")){
                    password=c.getValue();
                }
            }
        }
        System.out.println(username);

        if(username!=null&&password!=null){
            UserInfo userInfo=userService.login(username,password);

            if(userInfo!=null){
                request.getSession().setAttribute(Const.CURRENT_USER, userInfo);
            }else{
                try {
                    response.sendRedirect(request.getContextPath()+"/admin/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                response.sendRedirect(request.getContextPath()+"/admin/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}

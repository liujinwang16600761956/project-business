package com.neuedu.Filter;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter("/login.jsp")
public class ConstumFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String username=null;
        String password=null;
        HttpSession session = request.getSession();
        Cookie[] cookies=request.getCookies();
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

        if(username!=null&&password!=null){
            IUserService userService=new UserServiceImpl();
            UserInfo userInfo=userService.login(username,password);
            if(userInfo!=null){
                session.setAttribute("userInfo",userInfo);
            }
        }

        UserInfo userInfo=(UserInfo) session.getAttribute("userInfo");
        if(userInfo==null){
            response.sendRedirect("userList.jsp");
            return;
        }
        //请求通过过滤器
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

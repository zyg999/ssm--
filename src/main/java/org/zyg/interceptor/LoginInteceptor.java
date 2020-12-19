package org.zyg.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInteceptor implements HandlerInterceptor {
    private static final String[] IGNOGE_URIS = {"/userRegis", "/login", "/addUser", "/books", "/loginForm"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //获取请求的路径进行判断
        var servletPath = request.getServletPath();
        for (String s : IGNOGE_URIS) {
            if (servletPath.contains(s)) {
                return true;
            }
        }

        if (session.getAttribute("user") != null) {
            //如果请求不需要拦截，则直接放行请求
            return true;
        } else {

            //request.getRequestDispatcher("login").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/loginForm.jsp");

            return false;
        }
    }
}
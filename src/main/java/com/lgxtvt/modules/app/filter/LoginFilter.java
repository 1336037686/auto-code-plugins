//package com.lgxtvt.modules.app.filter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * 登陆验证过滤器
// * @author LGX_TvT
// * @date 2018-09-05 22:04
// */
//public class LoginFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) res;
//
//        String uri = request.getRequestURI();
//        System.out.println(uri);
//        if (uri.contains("login") || uri.contains("/js/") || uri.contains("/css/") ||
//                uri.contains("/plugins/") || uri.contains("/webjars/") || uri.contains("favicon") || ("/").equals(uri)){
//            chain.doFilter(request,response);
//        }else {
//            HttpSession session = request.getSession();
//            if(session != null){
//                Object object = session.getAttribute("user");
//                if(object != null){
//                    chain.doFilter(request,response);
//                }else {
//                    response.sendRedirect("/login.html");
//                }
//            }else {
//                response.sendRedirect("/login.html");
//            }
//        }
//    }
//
//    @Override
//    public void destroy() {
//
//    }
//}

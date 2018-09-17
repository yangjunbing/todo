package projects.bing.utils;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;

        Object session = request.getSession().getAttribute("admin");

        //如果用户没有登录是不能直接进入其他页面的
        if(session != null){

            System.out.println("---------session检查正常---------");
            filterChain.doFilter(request, response);
            return;
        }
        else{
            System.out.println("===未登录  进入登录页面===" + request.getRequestURL());
            if(request.getRequestURL().indexOf("/adminbing/index")> -1){
                filterChain.doFilter(request, response);
            }else{
                request.getRequestDispatcher("/adminbing/login").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
/*
public void doFilter(ServletRequest servletrequest, ServletResponse servletresponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletrequest;
        HttpServletResponse response=(HttpServletResponse) servletresponse;
        String servletPath = request.getServletPath();
        System.out.println("servletPath"+servletPath);
        Object session = request.getSession().getAttribute("pro");
        System.out.println("session="+session);
        //只要用户回到登录页面，就把session销毁，这样就需要重新登录
        if(servletPath.contains("/html/login.jsp") || servletPath.contains(" ")){
            System.out.println("销毁session");
            request.getSession().removeAttribute("pro");
        }
        //如果用户没有登录是不能直接进入其他页面的
        if(session != null){

            System.out.println("---------放行------------");
            chain.doFilter(request, response);

            return;
        }
        else{
            System.out.println("===进入判断体===");
            request.getRequestDispatcher("/html/login.jsp").forward(request, response);
        }


aaa*/

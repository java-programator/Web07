package pl.altkom.web;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleFilter implements Filter {
    private String param;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        param = filterConfig.getInitParameter("key");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setAttribute("attr", param);
        PrintWriter pw = servletResponse.getWriter();
        pw.println("<HTML><HEAD>");
        pw.println("<TITLE>Hello</TITLE>");
        pw.println("</HEAD><BODY>");
        filterChain.doFilter(servletRequest, servletResponse);
        pw.println("</BODY></HTML>");

    }

    @Override
    public void destroy() {

    }
}

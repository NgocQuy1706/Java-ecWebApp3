package com.ute.ecwebapp3.filter;

import com.ute.ecwebapp3.beans.Category;
import com.ute.ecwebapp3.beans.User;
import com.ute.ecwebapp3.models.CategoryModel;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "SessionInitFilter")
public class SessionInitFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        if(session.getAttribute("auth") == null) {
            session.setAttribute("auth",false);
            session.setAttribute("authUser", new User());
        }

        chain.doFilter(req, res);
    }
}

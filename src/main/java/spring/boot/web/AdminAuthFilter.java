package spring.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import spring.boot.model.User;
import spring.boot.service.UserService;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by alex on 03.04.17.
 */
@Component
public class AdminAuthFilter extends GenericFilterBean {

    @Autowired
    private UserService userService;

    private User user;

    @PostConstruct
    public void init() {
        user = (User)userService.loadUserByUsername("user");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        SecurityContextHolder.getContext().setAuthentication(new UserAuthentification(user));

        chain.doFilter(request, response);
    }
}

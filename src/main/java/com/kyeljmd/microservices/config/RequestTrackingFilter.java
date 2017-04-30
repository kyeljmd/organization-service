package com.kyeljmd.microservices.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by kyel on 4/13/2017.
 */
@Component
public class RequestTrackingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        if(httpRequest.getHeader("Authorization") != null) {
            String auth = (String) httpRequest.getHeader("Authorization");
            String token = auth.replace("Bearer ","");

            Claims claims = Jwts
                    .parser()
                    .setSigningKey("345345fsdgsf5345".getBytes("UTF-8"))
                    .parseClaimsJws(token)
                    .getBody();

            String result = (String) claims.get("organizationId");
            System.out.println("organization id "+result);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}

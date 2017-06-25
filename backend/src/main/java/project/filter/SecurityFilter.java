package project.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.util.WebUtils;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SecurityFilter implements Filter {

    private static final String CSRF_TOKEN_KEY = "X-CSRF-TOKEN";
    private static final String COOKIE_TOKEN_KEY = "JSESSIONID";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        if (!(request instanceof HttpServletRequest)) {
            return;
        }
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        Cookie cookieToken = WebUtils.getCookie(httpServletRequest, COOKIE_TOKEN_KEY);
        if (cookieToken == null) {
            chain.doFilter(request, response);
            return;
        }
        String headerToken = httpServletRequest.getHeader(CSRF_TOKEN_KEY);
        if (StringUtils.equals(headerToken, cookieToken.getValue())) {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}

package pl.edu.agh.soa.projekt.pas.service.security;

import eu.bitwalker.useragentutils.Browser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class WebBrowserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        boolean isChrome = Browser
                .parseUserAgentString(request.getHeader("User-Agent"))
                .getName()
                .toLowerCase()
                .contains("chrome");

        if (isChrome) {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {
    }
}

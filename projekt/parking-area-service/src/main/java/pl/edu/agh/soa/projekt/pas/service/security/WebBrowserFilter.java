package pl.edu.agh.soa.projekt.pas.service.security;

import eu.bitwalker.useragentutils.Browser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(urlPatterns = {"/*"})
public class WebBrowserFilter implements Filter {

    private static final List<String> EXCLUDED_PATHS = Arrays.asList(
            "rest",
            "ParkingPlaceSOAPServiceImpl",
            "StreetSOAPServiceImpl",
            "AreaSOAPServiceImpl"
    );

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getRequestURI();

        if (isExcludedPath(path) || isChrome(request.getHeader("User-Agent"))) {
            chain.doFilter(req, resp);
        } else {
            response.getWriter().println("Your browser is not supported. Try Chrome.");
        }
    }

    @Override
    public void destroy() {
    }

    private boolean isChrome(String userAgent) {
        return Browser
                .parseUserAgentString(userAgent)
                .getName()
                .toLowerCase()
                .contains("chrome");
    }

    private boolean isExcludedPath(String path) {
        return EXCLUDED_PATHS
                .stream()
                .anyMatch(path::contains);
    }
}

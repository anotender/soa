package pl.edu.agh.soa.lab3.przyklad.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AgeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Integer age = Integer.parseInt(req.getParameter("wiek"));

        if (age >= 18) {
            chain.doFilter(req, resp);
        }

        PrintWriter out = resp.getWriter();
        out.print("Nieletnim nie wolno pic piwa");
        out.close();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

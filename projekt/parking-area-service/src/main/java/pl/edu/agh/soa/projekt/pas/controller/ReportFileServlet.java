package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.service.report.ReportService;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "report-file-servlet", value = "report-file")
public class ReportFileServlet extends HttpServlet {

    @EJB
    private ReportService reportService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!SecurityUtils.isAdmin(request)) {
            response.getWriter().println("You are not allowed to access that resource");
            return;
        }

        if (!SecurityUtils.isAuthenticated(request)) {
            response.sendRedirect("login.xhtml");
            return;
        }

        try {
            reportService.preparePdfReport(response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

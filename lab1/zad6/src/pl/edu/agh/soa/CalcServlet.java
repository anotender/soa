package pl.edu.agh.soa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/kalkulator", name = "CalcServlet")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String paramX = req.getParameter("paramX");
        String paramY = req.getParameter("paramY");

        out.println("<html><body>");

        int sum = Integer.parseInt(paramX) + Integer.parseInt(paramY);

        out.println("Suma liczb x i y wynosi <b>" + sum + "</b>");
        out.println("</body></html>");

        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}

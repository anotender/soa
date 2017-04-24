package pl.edu.agh.soa.lab3.przyklad;

import pl.edu.agh.soa.lab3.przyklad.model.EkspertPiwny;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "WyborPiwaServlet", value = "/WybierzPiwo.do")
public class WyborPiwaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Porada piwna<br/>");
        String c = request.getParameter("kolor");
        out.println("<br/>Wybor kolor piwa: " + c + "<br/>");
        List<String> marki = EkspertPiwny.getMarki(c);
        request.setAttribute("marki", marki);
        request.getRequestDispatcher("wyniki.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

package pl.edu.agh.lab2.zad1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet", value = "/sprawdz")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imie = request.getParameter("imie");
        Integer wiek = Integer.parseInt(request.getParameter("wiek"));

        PrintWriter out = response.getWriter();

        if (!imie.endsWith("a")) {
            out.print("Nie kobieta");
            out.close();
            return;
        }

        if (wiek < 18) {
            out.print("Nie pelnoletnia");
            out.close();
            return;
        }

        out.print("Pelnoletnia kobieta");
        out.close();

    }
}

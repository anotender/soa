package pl.edu.agh.soa.lab6.zad3;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ConverterServlet", value = "/convert")
public class ConverterServlet extends HttpServlet {

    @EJB
    private Converter converter;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double temp = Double.parseDouble(request.getParameter("temp"));
        String direction = request.getParameter("direction");

        double result = "CF".equals(direction) ? converter.cels2Fahr(temp) : converter.fahr2Cels(temp);

        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

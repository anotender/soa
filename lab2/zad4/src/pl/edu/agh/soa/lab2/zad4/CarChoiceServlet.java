package pl.edu.agh.soa.lab2.zad4;

import pl.edu.agh.soa.lab2.zad4.car.CarChoiceHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "CarChoiceServlet", value = "/car")
public class CarChoiceServlet extends HttpServlet {

    private CarChoiceHelper helper = new CarChoiceHelper();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("typ");
        String[] range = request.getParameter("cena").split("-");

        int min = Integer.parseInt(range[0]);
        int max = Integer.parseInt(range[1]);

        PrintWriter out = response.getWriter();
        out.print(Arrays.toString(helper.getSuitableModels(type, min, max).toArray()));
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

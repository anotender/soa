package pl.edu.agh.soa.lab2.zad3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "AvgServlet", value = "/test")
public class AvgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            List<Integer> list = Collections
                    .list(request.getParameterNames())
                    .stream()
                    .map(request::getParameter)
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .boxed()
                    .collect(Collectors.toList());

            out.print(Arrays.toString(list.toArray()));
            out.close();
        } catch (Exception e) {
            out.print("Blad");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        if (request.getParameterMap().size() != 5) {
            out.print("Zla liczba parametrow");
            out.close();
            return;
        }

        double average = Collections
                .list(request.getParameterNames())
                .stream()
                .map(request::getParameter)
                .mapToInt(Integer::parseInt)
                .average()
                .getAsDouble();

        out.print("Srednia = " + average);
        out.close();
    }
}

package pl.edu.agh.soa.lab3;

import pl.edu.agh.soa.lab3.model.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "FilmServlet", value = "/filmy")
public class FilmServlet extends HttpServlet {

    private List<Film> films = Arrays.asList(
            new Film("Ojciec Chrzestny", "dramat", 1972, 120000000),
            new Film("Pluton", "wojenny", 1986, 50000000),
            new Film("Nagi instynkt", "thriller", 1992, 100000000)
    );

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("films", films);
        req.getRequestDispatcher("strona.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

package pl.edu.agh.soa.lab2.zad5.controller;

import pl.edu.agh.soa.lab2.zad5.utils.StringUtils;
import pl.edu.agh.soa.lab2.zad5.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private List<User> users = Arrays.asList(
            new User("matnow", "123456", "Mateusz", "Nowak"),
            new User("jankow", "qwerty", "Jan", "Kowalski")
    );

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (StringUtils.isEmpty(login)) {
            handleError("Nie podano loginu", request, response);
            return;
        }

        if (StringUtils.isEmpty(password)) {
            handleError("Nie podano hasla", request, response);
            return;
        }

        boolean authenticated = users
                .stream()
                .anyMatch(u -> u.getLogin().equals(login) && u.getPassword().equals(password));

        if (!authenticated) {
            handleError("Niepoprawne dane", request, response);
            return;
        }

        request.getSession().setAttribute("authenticated", true);
        response.sendRedirect("list");
    }

    private void handleError(String msg, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("authenticated", false);
        request.setAttribute("error", msg);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}

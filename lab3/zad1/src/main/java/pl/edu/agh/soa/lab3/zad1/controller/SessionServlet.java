package pl.edu.agh.soa.lab3.zad1.controller;

import pl.edu.agh.soa.lab3.zad1.model.UserStorage;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SessionServlet", value = "/session")
public class SessionServlet extends HttpServlet {
    private final UserStorage userStorage;

    @Inject
    public SessionServlet(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    //login
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("login") != null) {
            return;
        }

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (userStorage.getUsers().containsKey(login) && userStorage.getUsers().get(login).equals(password)) {
            request.getSession().setAttribute("login", login);
            userStorage.getActiveUsers().put(login, new Date());
            response.sendRedirect("active-users.jsp");
            return;
        }

        response.sendRedirect("index.jsp");
    }

    //logout
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = String.valueOf(request.getSession().getAttribute("login"));

        userStorage.getActiveUsers().remove(login);

        request.getSession().removeAttribute("login");
        response.sendRedirect("index.jsp");
    }
}

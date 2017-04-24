package pl.edu.agh.soa.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "GameServlet", value = "/zgaduj")
public class GameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("randomNumber") == null) {
            req.getSession().setAttribute("randomNumber", new Random().nextInt(100));
        }
        if (req.getSession().getAttribute("numberOfTries") == null) {
            req.getSession().setAttribute("numberOfTries", 0);
        }

        int numberOfTries = (Integer) req.getSession().getAttribute("numberOfTries");
        req.getSession().setAttribute("numberOfTries", ++numberOfTries);

        int randomNumber = (Integer) req.getSession().getAttribute("randomNumber");
        int userNumber = Integer.parseInt(req.getParameter("liczba"));

        String result;
        if (randomNumber < userNumber) {
            result = "gt";
        } else if (randomNumber == userNumber) {
            req.setAttribute("numberOfTries", req.getSession().getAttribute("numberOfTries"));
            req.getSession().removeAttribute("numberOfTries");
            req.getSession().removeAttribute("randomNumber");
            result = "eq";
        } else {
            result = "lt";
        }

        req.setAttribute("lastNumber", userNumber);
        req.setAttribute("result", result);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

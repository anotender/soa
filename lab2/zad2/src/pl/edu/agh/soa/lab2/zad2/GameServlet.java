package pl.edu.agh.soa.lab2.zad2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "GameServlet", value = "/game")
public class GameServlet extends HttpServlet {

    private String[] anwsers = new String[]{"kamien", "papier", "nozyce"};

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("wybor").toLowerCase();
        String computer = anwsers[new Random().nextInt(3)];

        System.out.println("user=" + user + " vs computer=" + computer);

        if (user.equals(computer)) {
            response.sendRedirect("remis.jsp");
            return;
        }

        if (("kamien".equals(user) && "nozyce".equals(computer)) ||
                ("nozyce".equals(user) && "papier".equals(computer)) ||
                ("papier".equals(user) && "kamien".equals(computer))) {
            response.sendRedirect("wygrana.jsp");
        } else {
            response.sendRedirect("przegrana.jsp");
        }
    }
}

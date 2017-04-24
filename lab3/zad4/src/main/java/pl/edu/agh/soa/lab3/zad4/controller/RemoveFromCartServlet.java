package pl.edu.agh.soa.lab3.zad4.controller;

import pl.edu.agh.soa.lab3.zad4.model.ShoppingCart;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveFromCartServlet", value = "/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {

    private final ShoppingCart shoppingCart;

    @Inject
    public RemoveFromCartServlet(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        shoppingCart.getProducts().remove(id);
        resp.sendRedirect("getCart");
    }
}

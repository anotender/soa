package pl.edu.agh.soa.lab3.zad4.controller;

import pl.edu.agh.soa.lab3.zad4.model.ShoppingCart;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/addToCart")
public class AddToCartServlet extends HttpServlet {

    private final ShoppingCart shoppingCart;

    @Inject
    public AddToCartServlet(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer sztuk = Integer.parseInt(req.getParameter("sztuk"));
        String id = req.getParameter("id");

        if (shoppingCart.getProducts().containsKey(id)) {
            sztuk += shoppingCart.getProducts().get(id);
        }
        shoppingCart.getProducts().put(id, sztuk);

        resp.sendRedirect("index.jsp");
    }
}

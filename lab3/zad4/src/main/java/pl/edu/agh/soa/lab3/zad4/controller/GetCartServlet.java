package pl.edu.agh.soa.lab3.zad4.controller;

import pl.edu.agh.soa.lab3.zad4.model.ShoppingCart;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetCartServlet", value = "/getCart")
public class GetCartServlet extends HttpServlet {

    private final ShoppingCart shoppingCart;

    @Inject
    public GetCartServlet(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("shoppingCart", shoppingCart.getProducts());
        req.getRequestDispatcher("koszyk.jsp").forward(req, resp);
    }


}

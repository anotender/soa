package pl.edu.agh.soa.lab3.zad4.model;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SessionScoped
public class ShoppingCart implements Serializable {
    private Map<String, Integer> products = new HashMap<String, Integer>();

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }
}

package pl.edu.agh.soa.lab3.zad1.model;

import javax.enterprise.context.ApplicationScoped;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class UserStorage {
    private Map<String, String> users = new HashMap<>();
    private Map<String, Date> activeUsers = new HashMap<>();

    public UserStorage() {
        users.put("matnow", "123456");
        users.put("jankow", "qwerty");
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public Map<String, Date> getActiveUsers() {
        return activeUsers;
    }
}

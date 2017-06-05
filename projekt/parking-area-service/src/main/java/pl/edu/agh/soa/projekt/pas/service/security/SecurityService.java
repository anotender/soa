package pl.edu.agh.soa.projekt.pas.service.security;

import pl.edu.agh.soa.projekt.pas.model.User;
import pl.edu.agh.soa.projekt.pas.service.user.UserService;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SecurityService {

    @EJB
    private UserService userService;

    public void login(String userName, String password) {
        User user = userService.getUser(userName);

        if (user.getPassword().equals(password)) {
            System.out.println("success");
        }
    }
}

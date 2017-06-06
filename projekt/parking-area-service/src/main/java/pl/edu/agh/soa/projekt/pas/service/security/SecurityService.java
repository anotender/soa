package pl.edu.agh.soa.projekt.pas.service.security;

import pl.edu.agh.soa.projekt.pas.exception.InvalidCredentialsException;
import pl.edu.agh.soa.projekt.pas.model.User;
import pl.edu.agh.soa.projekt.pas.service.user.UserService;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SecurityService {

    @EJB
    private UserService userService;

    public void login(String userName, String password) throws InvalidCredentialsException {
        User user = userService.getUser(userName);

        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid username or password");
        }
        SecurityUtils.getSession().setAttribute("user", user);
    }

    public void logout() {
        SecurityUtils.getSession().invalidate();
    }
}

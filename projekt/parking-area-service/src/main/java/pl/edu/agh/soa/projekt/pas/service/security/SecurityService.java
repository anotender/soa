package pl.edu.agh.soa.projekt.pas.service.security;

import pl.edu.agh.soa.projekt.pas.exception.InvalidCredentialsException;
import pl.edu.agh.soa.projekt.pas.exception.SessionAlreadyExistsException;
import pl.edu.agh.soa.projekt.pas.model.User;
import pl.edu.agh.soa.projekt.pas.service.user.UserService;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Singleton
@Startup
public class SecurityService {

    @EJB
    private UserService userService;

    private Map<User, HttpSession> sessions = new HashMap<>();

    public void login(String userName, String password) throws InvalidCredentialsException, SessionAlreadyExistsException {
        User user = userService.getUser(userName);

        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid username or password");
        }

        HttpSession session = SecurityUtils.getSession();
        session.setAttribute("user", user);

        if (!Objects.isNull(sessions.get(user))) {
            throw new SessionAlreadyExistsException("Session already exists");
        }
        sessions.put(user, session);
    }

    public void logout() {
        HttpSession session = SecurityUtils.getSession();
        User user = (User) session.getAttribute("user");
        sessions.remove(user);
        session.invalidate();
    }
}

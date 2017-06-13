package pl.edu.agh.soa.projekt.pas.service.security;

import org.apache.commons.codec.digest.DigestUtils;
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

        if (!DigestUtils.sha256Hex(password).equals(user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        HttpSession session = SecurityUtils.getSession();
        session.setAttribute("user", user);

        if (Objects.nonNull(sessions.get(user))) {
            throw new SessionAlreadyExistsException();
        }
        sessions.put(user, session);
    }

    public void logout() {
        HttpSession session = SecurityUtils.getSession();
        User user = (User) session.getAttribute("user");
        sessions.remove(user);
        session.invalidate();
    }

    public void invalidateSession(String username) {
        sessions
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getUsername().equals(username))
                .findFirst()
                .ifPresent(e -> {
                    e.getValue().invalidate();
                    sessions.remove(e.getKey());
                });
    }
}

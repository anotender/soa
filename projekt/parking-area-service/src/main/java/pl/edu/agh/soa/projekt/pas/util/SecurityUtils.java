package pl.edu.agh.soa.projekt.pas.util;

import pl.edu.agh.soa.projekt.pas.model.Role;
import pl.edu.agh.soa.projekt.pas.model.User;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class SecurityUtils {

    public static HttpSession getSession() {
        return getSession(getRequest());
    }

    public static Optional<User> getLoggedUser() {
        return getLoggedUser(getSession());
    }

    public static void redirect(String page) {
        try {
            FacesContext
                    .getCurrentInstance()
                    .getExternalContext()
                    .redirect(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAdmin() {
        return getLoggedUser()
                .filter(SecurityUtils::isAdmin)
                .isPresent();
    }

    public static boolean isAdmin(User u) {
        return u.getRole().equals(Role.ADMIN);
    }

    public static boolean isAdmin(HttpServletRequest req) {
        return getLoggedUser(getSession(req))
                .filter(SecurityUtils::isAdmin)
                .isPresent();
    }

    public static boolean isAuthenticated(HttpServletRequest req) {
        return getLoggedUser(getSession(req)).isPresent();
    }

    private static HttpSession getSession(HttpServletRequest req) {
        return req.getSession(true);
    }

    private static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();
    }

    private static Optional<User> getLoggedUser(HttpSession session) {
        Object u = session.getAttribute("user");
        return Objects.isNull(u) ? Optional.empty() : Optional.of((User) u);
    }
}

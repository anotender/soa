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
        return getRequest().getSession(true);
    }

    public static Optional<User> getLoggedUser() {
        Object u = getSession().getAttribute("user");
        return Objects.isNull(u) ? Optional.empty() : Optional.of((User) u);
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
        return isAdmin(getLoggedUser().orElseThrow(RuntimeException::new));
    }

    public static boolean isAdmin(User u) {
        return u.getRole().equals(Role.ADMIN);
    }

    private static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequest();
    }
}

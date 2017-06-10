package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.service.security.SecurityService;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class SecurityController {

    @EJB
    private SecurityService securityService;

    private String username;
    private String password;
    private String message;

    public void login() {
        try {
            securityService.login(username, password);
            SecurityUtils.redirect("index.xhtml");
        } catch (Exception e) {
            message = e.getMessage();
        }
    }

    public void logout() {
        securityService.logout();
        SecurityUtils.redirect("login.xhtml");
    }

    public boolean isAuthenticated() {
        return SecurityUtils.getLoggedUser().isPresent();
    }

    public boolean isAdmin() {
        return SecurityUtils.isAdmin();
    }

    public boolean isNotEmpty(String s) {
        return s != null && s.length() != 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

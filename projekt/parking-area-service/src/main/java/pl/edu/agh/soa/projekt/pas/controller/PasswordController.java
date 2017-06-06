package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.service.user.UserService;
import pl.edu.agh.soa.projekt.pas.util.SecurityUtils;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class PasswordController {
    @EJB
    private UserService userService;

    private String username = SecurityUtils
            .getLoggedUser()
            .orElseThrow(IllegalStateException::new)
            .getUsername();
    private String newPassword;
    private String newPasswordConfirmed;
    private String message;

    public void changePassword() {
        if (!newPassword.equals(newPasswordConfirmed)) {
            message = "New password and confirmed password must be the same";
            return;
        }

        try {
            userService.changePassword(username, newPassword);
            SecurityUtils.redirect("index.xhtml");
        } catch (Exception e) {
            message = "Something went wrong";
        }
    }

    public boolean isNotEmpty(String s) {
        return s != null && s.length() != 0;
    }

    public boolean isAdmin() {
        return SecurityUtils
                .getLoggedUser()
                .orElseThrow(IllegalStateException::new)
                .getRole()
                .equals("admin");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordConfirmed() {
        return newPasswordConfirmed;
    }

    public void setNewPasswordConfirmed(String newPasswordConfirmed) {
        this.newPasswordConfirmed = newPasswordConfirmed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

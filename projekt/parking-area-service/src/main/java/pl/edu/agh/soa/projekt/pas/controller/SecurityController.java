package pl.edu.agh.soa.projekt.pas.controller;

import pl.edu.agh.soa.projekt.pas.service.security.SecurityService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class SecurityController {

    @EJB
    private SecurityService securityService;

    private String username;
    private String password;

    public void login() {
        try {
            securityService.login(username, password);
        } catch (Exception e) {
            System.out.println("error");
        }
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
}

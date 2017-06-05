package pl.edu.agh.soa.projekt.pas.service.user;

import pl.edu.agh.soa.projekt.pas.model.User;
import pl.edu.agh.soa.projekt.pas.repository.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.Transactional;

@Singleton
@Startup
@Transactional
public class UserService {

    @EJB
    private UserRepository userRepository;

    public User getUser(String username){
        return userRepository
                .findOneByUsername(username)
                .orElseThrow(RuntimeException::new);
    }

}

package pl.edu.agh.soa.projekt.pas.service.user;

import org.apache.commons.codec.digest.DigestUtils;
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

    public User getUser(String username) {
        return userRepository
                .findOneByUsername(username)
                .orElseThrow(RuntimeException::new);
    }

    public void changePassword(String username, String newPassword) {
        User user = getUser(username);
        user.setPassword(DigestUtils.sha256Hex(newPassword));
        userRepository.update(user);
    }
}

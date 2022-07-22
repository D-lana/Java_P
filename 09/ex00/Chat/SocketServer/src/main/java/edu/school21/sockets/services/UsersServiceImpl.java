package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {

    private UsersRepositoryImpl usersRepositoryImpl;
    private PasswordEncoder encoder;

    @Autowired
    public UsersServiceImpl(UsersRepositoryImpl usersRepositoryImpl, PasswordEncoder encoder) {
        this.usersRepositoryImpl = usersRepositoryImpl;
        this.encoder = encoder;

    }

    @Override
    public int singIn(String login, String password) {
        User userNew;
        Optional<User> userO = usersRepositoryImpl.findByLogin(login);

        userNew = new User(null, login, encoder.encode(password));
        if (userO.toString() == "Optional.empty"){
            usersRepositoryImpl.save(userNew);
            return (0);
        }
        return (1);
    }
}

package edu.school21.sockets.services;

import org.springframework.stereotype.Component;

@Component
public interface UsersService {
    int singIn(String login, String password);
}

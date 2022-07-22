package edu.school21.app;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.models.Chatroom;
import edu.school21.models.Message;
import edu.school21.models.User;
import edu.school21.repositories.MessagesRepository;
import edu.school21.repositories.MessagesRepositoryJdbcImpl;
import edu.school21.repositories.NotSavedSubEntityException;


public class Program {
    private static final String HOST = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "dlana";
    private static final String PASSWORD = "";


    public static void main(String[] args) {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(HOST);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);

        User creator = new User(1L, "user", "user", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(1L, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(ds);
        try {
            messagesRepository.save(message);
        }
        catch (NotSavedSubEntityException e) {
            System.err.println("Error! Message not save.");
            System.exit(1);
        }
        System.out.println(message.getMessageId());
    }
}


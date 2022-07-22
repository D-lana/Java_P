package edu.school21.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.models.Chatroom;
import edu.school21.models.Message;
import edu.school21.models.User;

import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final HikariDataSource ds;
    public MessagesRepositoryJdbcImpl(HikariDataSource ds) {
        this.ds = ds;
    }

    @Override
    public Optional<Message> findById(Long id) throws SQLException {

        Connection connect = ds.getConnection();
        String request = "SELECT * FROM chat.message WHERE messageid = " + id;
        try {
            Statement statement = connect.createStatement();
            ResultSet result = statement.executeQuery(request);
            result.next();
            User user = new User(1L, "dlana",
                    "123",
                    null,
                    null);
            Chatroom chatroom = new Chatroom(1L,
                    "my room",
                    null,
                    null);
            Optional<Message> messageText = Optional.of(new Message(result.getLong(1),
                    user,
                    chatroom,
                    result.getString("messageText"),
                    LocalDateTime.of(2022, 5, 22, 22, 22)));
            return messageText;
        }
        catch (SQLException e) {
            throw new NoSuchElementException();
        }
    }
}


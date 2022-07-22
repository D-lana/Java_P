package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository<User> {

    private static Connection connection;
    private static PreparedStatement myPreparestatement;

    public UsersRepositoryJdbcImpl(DataSource dataSource) throws SQLException {
        connection = dataSource.getConnection();
        this.createTable();
    }

    private void createTable() throws SQLException {
        try {
            String SQL = "CREATE TABLE IF NOT EXISTS users (identifier BIGINT PRIMARY KEY, email VARCHAR(50) NOT NULL UNIQUE);";
            myPreparestatement = connection.prepareStatement(SQL);
            User user01 = new User(1, "aaa@yandex.ru");
            User user02 = new User(2, "bbb@yandex.ru");
            User user03 = new User(3, "ccc@yandex.ru");
            if (this.findById(user01.getIdentifier()) == null) {
                this.save(user01);
            }
            if (this.findById(user02.getIdentifier()) == null) {
                this.save(user02);
            }
            if (this.findById(user03.getIdentifier()) == null) {
                this.save(user03);
            }
            myPreparestatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public User findById(Long id) {
        User people = null;
        try {
            myPreparestatement = connection.prepareStatement("SELECT * FROM users WHERE identifier=?");
            myPreparestatement.setLong(1, id);
            ResultSet resultSet = myPreparestatement.executeQuery();
            resultSet.next();
            people = new User();
            people.setIdentifier(resultSet.getLong("identifier"));
            people.setEmail(resultSet.getString("email"));
        } catch (SQLException e) {
            return people;
        }
        return people;
    }

    @Override
    public List<User> findAll() {
        List<User> people = null;
        try {
            String SQL = "SELECT * FROM users";
            myPreparestatement = connection.prepareStatement(SQL);
            ResultSet resultSet = myPreparestatement.executeQuery();
            people = new ArrayList<>();
            while(resultSet.next()) {
                User person = new User();

                person.setIdentifier(resultSet.getLong("identifier"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }

        } catch (SQLException e) {
            System.err.println("Table not found");
        }
        return people;
    }

    @Override
    public void save(User entity) {
        try {
            String SQL = "INSERT INTO users VALUES(?, ?)";
            myPreparestatement = connection.prepareStatement(SQL);
            myPreparestatement.setLong(1, entity.getIdentifier());
            myPreparestatement.setString(2, entity.getEmail());

            myPreparestatement.executeUpdate();
        }
        catch (SQLException e) {
            System.err.println("User id [" + entity.getIdentifier() + "] already exist");
        }
    }

    @Override
    public void update(User entity) {
        try {
            String SQL = "UPDATE users SET email=? WHERE identifier=?";
            myPreparestatement = connection.prepareStatement(SQL);
            myPreparestatement.setString(1, entity.getEmail());
            myPreparestatement.setLong(2, entity.getIdentifier());


            myPreparestatement.executeUpdate();
        }
        catch (SQLException e) {
        }
    }

    @Override
    public void delete(Long id) {
        try {
            String SQL = "DELETE FROM users WHERE identifier=?";
            myPreparestatement = connection.prepareStatement(SQL);
            myPreparestatement.setLong(1, id);

            myPreparestatement.executeUpdate();

        }
        catch (SQLException e) {
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User people;
        try {
            myPreparestatement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            myPreparestatement.setString(1, email);
            ResultSet resultSet = myPreparestatement.executeQuery();
            resultSet.next();
            people = new User();
            people.setIdentifier(resultSet.getInt("identifier"));
            people.setEmail(resultSet.getString("email"));
        } catch (SQLException e) {
            return Optional.empty();
        }
        Optional<User> userOptional = Optional.of(people);
        return userOptional;
    }

    private void close() throws SQLException {
        connection.close();
    }
}

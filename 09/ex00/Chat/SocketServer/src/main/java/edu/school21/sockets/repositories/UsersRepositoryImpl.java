package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

import java.sql.*;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository<User> {

    private final JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (resultSet, index) ->
            new User(resultSet.getLong("userId"), resultSet.getString("login"), resultSet.getString("password"));

    public UsersRepositoryImpl(DataSource dataSource) throws SQLException {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.createTable();
    }

    private void createTable() throws SQLException {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS usersChat (userId BIGSERIAL PRIMARY KEY, login VARCHAR(50) NOT NULL UNIQUE, password VARCHAR NOT NULL);");
    }

    @Override
    public void save(User entity) {
        if (this.findById(entity.getUserId()) != null) {
            entity.setUserId(entity.getUserId() + 1);
        }
        jdbcTemplate.update("INSERT INTO usersChat (login, password) values(?, ?) ", entity.getLogin(), entity.getPassword());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE usersChat SET login=?, password=? WHERE userId=?", entity.getLogin(), entity.getPassword(), entity.getUserId());
    }

    @Override
    public void delete(Long id) {
        if (jdbcTemplate.update("DELETE FROM usersChat WHERE userId=?", id) != 0) {
            return;
        }
    }

    @Override
    public List<User> findAll() throws DataAccessException {
        return jdbcTemplate.query("SELECT * FROM usersChat", userRowMapper);
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM usersChat WHERE userId=?",  new Object[]{id}, userRowMapper)
                .stream().findAny().orElse(null);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User> userO = jdbcTemplate.query("SELECT * FROM usersChat  WHERE login=?",
                        new Object[]{login}, userRowMapper)
                .stream().findAny();
        return (userO);
    }

    private void close() throws SQLException {
        Connection data = jdbcTemplate.getDataSource().getConnection();
        data.close();
    }

}

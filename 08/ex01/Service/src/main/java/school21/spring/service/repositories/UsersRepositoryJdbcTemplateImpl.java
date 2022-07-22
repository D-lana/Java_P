package school21.spring.service.repositories;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository<User> {

    private final JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (resultSet, index) ->
            new User(resultSet.getLong("identifier"), resultSet.getString("email"));

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.createTable();
    }

    private void createTable() {
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users (identifier BIGINT PRIMARY KEY , email VARCHAR(50) NOT NULL UNIQUE);");
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
    }

    @Override
    public void save(User entity) {
        if (this.findById(entity.getIdentifier()) != null) {
            System.err.println("User id [" + entity.getIdentifier() + "] already exist");
            return ;
        }
        jdbcTemplate.update("INSERT INTO users VALUES(?, ?)", entity.getIdentifier(), entity.getEmail());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET email=? WHERE identifier=?", entity.getEmail(), entity.getIdentifier());
    }

    @Override
    public void delete(Long id) {
        if(jdbcTemplate.update("DELETE FROM users WHERE identifier=?", id) != 0) {
            return ;
        }
    }

    @Override
    public List<User> findAll() throws DataAccessException {
        return jdbcTemplate.query("SELECT * FROM users", userRowMapper);
    }

    @Override
    @Deprecated
    public User findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE identifier=?", new Object[]{id}, userRowMapper)
                .stream().findAny().orElse(null);
    }

    @Override
    @Deprecated
    public Optional<User> findByEmail(String email) {
        Optional<User> userO = jdbcTemplate.query("SELECT * FROM users  WHERE email=?",
                        new Object[]{email},
                        new BeanPropertyRowMapper<>(User.class))
                        .stream().findAny();
        return(userO);
    }

    private void close() throws SQLException {
        Connection data = jdbcTemplate.getDataSource().getConnection();
        data.close();
    }
}

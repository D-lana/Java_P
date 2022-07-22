package edu.school21.sockets.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.repositories.UsersRepositoryImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.SQLException;

@Configuration
@ComponentScan("edu.school21.sockets")
@PropertySource("classpath:db.properties")
public class SocketsApplicationConfig {
    @Value("${db.driver.name}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String username;
    @Value("${db.user}")
    private String password;

    @Bean
    public HikariDataSource hikaridataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setDriverClassName(driver);
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setJdbcUrl(url);
        return hikariDataSource;
    }

    @Bean
    public UsersRepositoryImpl usersRepositoryImpl() throws SQLException {
        UsersRepositoryImpl usersRepository = new UsersRepositoryImpl(hikaridataSource());
        return usersRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}



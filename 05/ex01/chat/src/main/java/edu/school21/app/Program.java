package edu.school21.app;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.models.Message;
import edu.school21.repositories.MessagesRepository;
import edu.school21.repositories.MessagesRepositoryJdbcImpl;


public class Program {
    private static final String HOST = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "dlana";
    private static final String PASSWORD = "";


    public static void main(String[] args) throws SQLException , NoSuchElementException {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(HOST);
        ds.setUsername(USER);
        ds.setPassword(PASSWORD);

        MessagesRepository msg = new MessagesRepositoryJdbcImpl(ds);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a message ID");
        System.out.print("-> ");
        long index;
        if (!scan.hasNextInt()) {
            System.err.println("Error! Illegal Argument.");
            System.exit(1);
        }
        index = scan.nextLong();
        try {
            Message msgGet = msg.findById(index).get();
            System.out.println(msgGet);
        }
        catch (NoSuchElementException e) {
            System.err.println("Error! Message id [" + index + "] not found.");
            System.exit(1);
        }
    }
}


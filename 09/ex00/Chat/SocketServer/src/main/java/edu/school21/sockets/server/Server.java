package edu.school21.sockets.server;

import edu.school21.sockets.config.SocketsApplicationConfig;
import edu.school21.sockets.services.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final int port;
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader waitClient;
    private static BufferedWriter out;
    private String login;
    private String password;

    public Server(int port) {

        this.port = port;
        ApplicationContext context = new AnnotationConfigApplicationContext(SocketsApplicationConfig.class);
        UsersService repository = context.getBean(UsersService.class);

        try {
            try  {
                server = new ServerSocket(this.port);
                System.out.println("Server run!");
                clientSocket = server.accept();
                try {
                    waitClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    String signUp = waitClient.readLine();
                    if (signUp.equals("signUp")) {
                        out.write("Enter username:\n");
                        out.flush();
                        login = waitClient.readLine();

                        out.write("Enter password:\n");
                        out.flush();
                        password = waitClient.readLine();

                        if (repository.singIn(login, password) == 0){
                            out.write("Successful!");
                        }
                        else {
                            out.write("This login already exists. Fail.");
                        }
                        out.flush();
                    }
                } finally {
                    clientSocket.close();
                    waitClient.close();
                    out.close();
                }
            } finally {
                System.out.println("Server close!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public int getPort() {
        return port;
    }
}

package edu.school21.sockets.client;

import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader reader;

    private static BufferedReader in;
    private static BufferedWriter out;
    private final int port;

    public Client(int port) {
        this.port = port;

        try {
            try {

                clientSocket = new Socket("localhost", this.port);

                reader = new BufferedReader(new InputStreamReader(System.in));

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                System.out.println("Hello from Server!");
                System.out.print(">");

                String signUp = reader.readLine();

                out.write( signUp + "\n");
                out.flush();
                String serverWord = in.readLine();
                if (serverWord != null) {
                    System.out.println(serverWord);

                    System.out.print(">");
                    String login = reader.readLine();

                    out.write( login + "\n");
                    out.flush();
                    serverWord = in.readLine();
                    System.out.println(serverWord);

                    System.out.print(">");
                    String password = reader.readLine();
                    out.write( password + "\n");
                    out.flush();
                    serverWord = in.readLine();
                    System.out.println(serverWord);
                }
            } finally {
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public int getPort() {
        return port;
    }
}



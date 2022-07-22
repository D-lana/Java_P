package edu.school21.sockets.app;

import edu.school21.sockets.client.Client;

public class Main {
    public static void main (String[] args) {
        int port;
        try {
            if (args.length != 1 || args[0] == null || args[0].isEmpty()
                    || args[0].length() < 15 || !args[0].substring(0, 14).equals("--server-port=")) {
                throw new NumberFormatException();
            }
            port = Integer.parseInt(args[0].substring(14, args[0].length()));
            Client client = new Client(port);
        } catch (NumberFormatException e) {
            errorPrint("Error: invalid arguments.\nTry: --server-port=[NumberPort]");
        }
    }

    public static void errorPrint(String str) {
        System.err.println(str);
        System.exit(-1);
    }
}

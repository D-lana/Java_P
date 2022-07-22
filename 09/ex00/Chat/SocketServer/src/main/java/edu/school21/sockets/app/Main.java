package edu.school21.sockets.app;

import edu.school21.sockets.server.Server;

public class Main {
    public static void main (String[] args) {
        int port;
        try {
            if (args.length != 1 || args[0] == null || args[0].isEmpty()
                    || args[0].length() < 8 || !args[0].substring(0, 7).equals("--port=")) {
                throw new NumberFormatException();
            }
            port = Integer.parseInt(args[0].substring(7, args[0].length()));
            Server server = new Server(port);

        } catch (NumberFormatException e) {
            errorPrint("Error: invalid arguments.\nTry: --port=[NumberPort]");
        }
    }

    public static void errorPrint(String str) {
        System.err.println(str);
        System.exit(-1);
    }
}

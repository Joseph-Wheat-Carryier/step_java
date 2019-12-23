package day18.WeChatOnConsole;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ClientThread clientThread = new ClientThread();
        boolean done = false;
        ServerSocket loginServer = new ServerSocket(9999);
        ServerSocket chatServer = new ServerSocket(8888);

        while (!done) {
            Socket clients = loginServer.accept();
            Users users = new Users(clients);
            Thread t = new Thread(users);
            t.start();
        }
    }
}

package day17;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestEchoServer {
    public static void main(String[] args) throws IOException {
        try (Socket client = new Socket("localhost", 8189)) {
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream p = new DataOutputStream(client.getOutputStream());
            boolean done = false;
            Scanner out = new Scanner(System.in);
            System.out.println(in.readUTF());
            while (!done) {
                String outline = out.nextLine();
                p.writeUTF(outline);
                String line = in.readUTF();
                if (!line.equals("Echo:BYE")) {
                    System.out.println(line);
                }else {
                    System.out.println(line);
                    done = true;
                }
            }
        }
    }
}

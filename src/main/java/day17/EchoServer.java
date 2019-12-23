package day17;

import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(8189)) {
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                DataOutputStream out = new DataOutputStream(outStream);
                out.writeUTF("Hello!Enter BYE to exit.");


                try (DataInputStream in = new DataInputStream(inStream)) {
                    boolean done = false;
                    while (!done) {
                        String line = in.readUTF();
                        out.writeUTF("Echo:" + line);
                        if (line.trim().equals("BYE"))
                            done = true;
                    }
                }
            }
        }
    }
}

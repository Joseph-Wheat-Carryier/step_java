package day18.WeChatOnConsole;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Socket client = new Socket("localhost",9999);
        InputStream inputStream = client.getInputStream();
        OutputStream outputStream = client.getOutputStream();
        DataInputStream dataInput = new DataInputStream(inputStream);
        DataOutputStream dataoutput = new DataOutputStream(outputStream);
        while(true){
            System.out.println(dataInput.readUTF());
            dataoutput.writeUTF(scan.nextLine());
        }
    }
}

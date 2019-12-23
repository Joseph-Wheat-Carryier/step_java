package day17;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SocketDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中");
        DatagramSocket server  = new DatagramSocket(9999);
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        server.receive(packet);
        byte []datas =  packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas,0,len));
        server.close();
    }
}

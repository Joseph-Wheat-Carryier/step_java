package day17;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SocketDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中");
        DatagramSocket client = new DatagramSocket(8888);
        String data = "锄禾日当午";
        byte[] data1 = data.getBytes();
        DatagramPacket packet = new DatagramPacket(data1, 0, data1.length,
                new InetSocketAddress("localhost",9999));
        client.send(packet);
        client.close();;
    }
}

package com.xjtu.ssmidea.domain.frame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class demo1_receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(6666);						//创建socket相当于创建码头
        DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);		//创建packet相当于创建集装箱

        while(true) {
            socket.receive(packet);												//接收货物
            byte[] arr = packet.getData();
            int len = packet.getLength();
            String ip = packet.getAddress().getHostAddress();
            System.out.println(ip + ":" + new String(arr,0,len));
        }
    }
}

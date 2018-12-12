package com.xjtu.ssmidea.domain.frame;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class demo2_send {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();		//创建socket相当于创建码头
        Scanner sc = new Scanner(System.in);

        while(true) {
            String str = sc.nextLine();
            if("quit".equals(str))
                break;
            DatagramPacket packet = 							//创建packet相当于创建集装箱
                    new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
            socket.send(packet);			//发货
        }
        socket.close();
    }
}

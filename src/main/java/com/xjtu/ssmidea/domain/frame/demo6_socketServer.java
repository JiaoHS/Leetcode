package com.xjtu.ssmidea.domain.frame;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class demo6_socketServer {
    public static void main(String[] args) throws IOException {
        demo1();

        //demo2();
        return;
    }

    public static void demo2() throws IOException {
        ServerSocket server = new ServerSocket(9999);	//创建服务器
        while(true) {
            final Socket socket = server.accept();				//接受客户端的请求
            new Thread() {
                public void run() {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintStream ps = new PrintStream(socket.getOutputStream());
                        ps.println("欢迎咨询传智播客");
                        System.out.println(br.readLine());
                        ps.println("报满了,请报下一期吧");
                        System.out.println(br.readLine());
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public static void demo1() throws IOException {
        ServerSocket server = new ServerSocket(9999);	//创建服务器
        Socket socket = server.accept();				//接受客户端的请求
        InputStream is = socket.getInputStream();		//获取输入流
        OutputStream os = socket.getOutputStream();		//获取输出流

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintStream ps = new PrintStream(os);

        ps.println("欢迎咨询传智播客");
        System.out.println(br.readLine());
        ps.println("报满了,请报下一期吧");
        System.out.println(br.readLine());
        server.close();
        socket.close();
    }
}

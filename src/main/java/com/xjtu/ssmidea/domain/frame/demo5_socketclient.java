package com.xjtu.ssmidea.domain.frame;

import java.io.*;
import java.net.Socket;

public class demo5_socketclient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);		//创建Socket指定ip地址和端口号
        InputStream is = socket.getInputStream();			//获取输入流
        OutputStream os = socket.getOutputStream();			//获取输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        PrintStream ps = new PrintStream(os);

        System.out.println(br.readLine());
        ps.println("我想报名就业班");
        System.out.println(br.readLine());
        ps.println("爷不学了");
        socket.close();
    }
}

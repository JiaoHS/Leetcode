package com.xjtu.ssmidea.domain.frame;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class demo7_testsocketservice {
    public static void main(String[] args) throws IOException {
        //1、先读取一个文件
        File file = GetFile();
        //2、发送文件名到服务器
        Socket socket=new Socket("127.0.0.1",12345);
        BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream ps=new PrintStream(socket.getOutputStream());
        ps.println(file.getName());

        //6、接收结果，如果存在文件名给与提示退出
        String result=br.readLine();
        if(result.equals("存在")){
            System.out.println("请上传的文件已存在，请重新上传");
            socket.close();
            return;
        }
        //7、如果不存在则定义FileInputStream对象读取文件，写到网络
        FileInputStream is=new FileInputStream(file);
        int len;
        byte[] bytes=new byte[8192];
        while ((len=is.read(bytes))!=-1){
            ps.write(bytes,0,len);
        }
        is.close();
        socket.close();
    }

    public static File GetFile() {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入一个路径");
        while (true) {
            String line = scan.nextLine();
            File file = new File(line);
            if (!file.exists()) {
                System.out.println("录入的文件不存在，请重新输入");
            } else if (file.isDirectory()) {
                System.out.println("您输入的是文件夹路径，请输入一个文件路径");
            } else {
                return file;
            }
        }
    }
}

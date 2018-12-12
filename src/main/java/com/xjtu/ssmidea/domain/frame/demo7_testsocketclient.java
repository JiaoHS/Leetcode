package com.xjtu.ssmidea.domain.frame;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class demo7_testsocketclient {
    public static void main(String[] args) throws IOException {
        //3、建立多线程服务器
        ServerSocket server=new ServerSocket(12345);
        System.out.println("服务器启动，绑定12345端口");
        //4、读取客户端传的文件名
        while (true){
            Socket socket=server.accept();
            new Thread(){
                @Override
                public void run() {
                    try {
                        InputStream is=socket.getInputStream();
                        BufferedReader br=new BufferedReader(new InputStreamReader(is));
                        PrintStream ps=new PrintStream(socket.getOutputStream());
                        String fileName=br.readLine();
                        //5、判断文件是否存在，将结果返回客户端
                        File dir=new File("update");
                        dir.mkdir();
                        File file=new File(dir,fileName);//封装成File对象
                        if(file.exists()){
                           ps.println("存在");
                           socket.close();
                            return;
                        }else {
                            ps.println("不存在");
                        }
                        //定义FileOutputStream从网络读取文件，存储到本地
                        FileOutputStream fos=new FileOutputStream(file);
                        byte[] arr=new byte[8192];
                        int len;
                       while ((len=is.read(arr))!=-1){
                           fos.write(arr,0,len);
                       }
                       fos.close();
                       socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }.start();

        }

    }
}

package com.xjtu.ssmidea.domain;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class filetest {
    public static void main(String[] args) throws IOException {
        //demo1();

        //demo2();

        //demo3();
        //demo4();

//        demo5();
        //demo6();
        //demo7();
        //demo8();

        //demo9();

        //demo10();

        //demo11();
        //demo12();
        //demo13();
        //demo14();
        //demo15();
        File src = new File("D:\\test");
        File det = new File("D:\\downloadcopy");
        //System.out.println(demo16(dir));

        //demo17(det);

        //demo18(src, det);
//        demo19(src, 0);
        //System.out.println(demo21(8));
        //demo22();
        System.out.println(demo23(8));
        System.out.println("ok");
    }

    private static int demo23(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        //所有的人加到集合中
        for (int i = 1; i <= num; i++) {
            list.add(i);
        }
        int count = 1;
        //当集合中的人数大于1的时候继续循环
        for (int i = 0; list.size() != 1; i++) {
            //当索引等于集合长度的时候，索引置于0
            if (list.size() == i) {
                i = 0;
            }
            //删除一个元素后索引前移动，应该--
            if (count % 3 == 0) {
                list.remove(i--);
            }
            count++;
        }
        return list.get(0);
    }

    private static void demo22() {
        BigInteger bint = new BigInteger("1");

        for (int i1 = 1; i1 < 1000; i1++) {
            BigInteger j = new BigInteger(i1 + "");
            bint = j.multiply(bint);
        }
        int count = 0;
        for (int i = 0; i < bint.toString().length(); i++) {
            if ('0' == bint.toString().charAt(i)) {
                count++;
            }
        }
        int count2 = 0;
        StringBuilder sb = new StringBuilder(bint.toString());
        String str = sb.reverse().toString();
        for (int length = 0; length < str.length() - 1; length++) {
            if ('0' == str.charAt(length)) {
                count2++;
            } else {
                break;
            }
        }
        System.out.println(count);
        System.out.println(count2);
    }

    private static int demo21(int num) {
        //斐波那契数列 递归
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return demo21(num - 2) + demo21(num - 1);
        }
    }

    private static int demo20(int num) {
        int[] nums = new int[8];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = nums[i - 2] + nums[i - 1];
        }
        return nums[nums.length - 1];
    }

    private static void demo19(File src, int i) {
        File[] files = src.listFiles();
        for (File file : files) {
            for (int j = 0; j <= i; j++) {
                System.out.print("\t");
            }
            System.out.println(file);
            if (file.isDirectory()) {
                demo19(file, i + 1);
            }
        }
    }

    private static void demo18(File src, File dst) throws IOException {
        if (src.equals(dst)) {
            return;
        } else {
            File newDir = new File(dst, src.getName());
            newDir.mkdir();
            File[] files = src.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    //是文件就读写
                    BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(newDir, file.getName())));

                    int b;
                    while ((b = bis.read()) != -1) {
                        bos.write(b);
                    }
                    bis.close();
                    bos.close();
                } else {
                    demo18(file, newDir);
                }
            }
        }
    }

    private static void demo17(File dir) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else {
                demo17(file);
            }
        }
        dir.delete();
    }

    public static int demo16(File dir) {
        int len = 0;

        File[] dirs = dir.listFiles();
        for (File file : dirs) {
            if (file.isFile()) {
                len += file.length();
            } else {
                len += demo16(file);
            }
        }
        return len;
    }

    public static void demo15() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("g.txt"), true);
        pw.write(97);
        pw.println("大家好");
        pw.println("你好");                //自动刷出,只针对的是println方法
        pw.close();
    }

    public static void demo14() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("data.txt"), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("data2.txt"), "gbk");

        int line;
        while ((line = isr.read()) != -1) {
            osw.write(line);
        }
        isr.close();
        osw.close();
    }

    public static void demo13() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("data2.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line + "\r\n");
        }
        br.close();
        bw.close();
    }

    public static void demo12() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("data2.txt"));
        int b;
        while ((b = br.read()) != -1) {
            System.out.println(b);
            bw.write(b);
        }
        br.close();
        bw.close();
    }

    public static void demo11() throws IOException {
        try (
                FileInputStream fis = new FileInputStream("aaa.txt");
                FileOutputStream fos = new FileOutputStream("bbb.txt");
        ) {
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        }
    }

    public static void demo10() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("aaa.txt");
            fos = new FileOutputStream("bbb.txt");
            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } finally {
                if (fos != null)
                    fos.close();
            }
        }
    }

    public static void demo9() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("dance.mp4"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("dance3.mp4"));
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        bis.close();
        bos.close();
    }

    public static void demo8() throws IOException {
        FileInputStream fis = new FileInputStream("dance.mp4");
        FileOutputStream fos = new FileOutputStream("dance2.mp4");
        byte[] bytes = new byte[1024 * 8];
        int b;
        while ((b = fis.read(bytes)) != -1) {
            fos.write(bytes, 0, b);
        }
        fis.close();
        fos.close();
    }

    public static void demo7() throws IOException {
        FileInputStream fis = new FileInputStream("5716.gif");
        FileOutputStream fos = new FileOutputStream("copy2.gif");
        byte[] bytes = new byte[fis.available()];
        fis.read(bytes);
        fos.write(bytes);
        fis.close();
        fos.close();
    }

    public static void demo6() throws IOException {
        FileInputStream fis = new FileInputStream("5716.gif");
        FileOutputStream fos = new FileOutputStream("copy.gif");
        int b;
        while ((b = fis.read()) != -1) {
            fos.write(b);
        }
        fis.close();
        fos.close();
    }

    public static void demo5() throws IOException {
        //创建字节输出流 没有路径就创建
        FileOutputStream fio = new FileOutputStream("data.txt", true);
        fio.write('a');
        fio.write(99);
        fio.write(100);
        fio.close();
    }

    public static void demo4() throws IOException {
        FileInputStream input = new FileInputStream("data.txt");
        int b;
        while ((b = input.read()) != -1) {
            System.out.println(b);
        }
    }

    public static void demo3() {
        File dir = new File("aaa");
        dir.delete();
        System.out.println(dir.mkdir());
        File dir2 = new File("aaa\\ddd");
        dir.renameTo(dir2);
        System.out.println(dir2.mkdirs());
    }

    public static void demo2() {
        File file = new File("da123ta.txt");
        try {
            System.out.println(file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void demo1() {
        String parent = "F:\\";
        String child = "data.txt";
        File file = new File(parent, child);
        System.out.println(file.exists());

        File file2 = new File("F:");
        String child2 = "data.txt";
        File file3 = new File(file2, child);
        System.out.println(file3.exists());
    }
}

package com.xjtu.ssmidea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class helloworld {
    public static void main(String[] args) {
//        Scanner scan=new Scanner(System.in);//创建键盘录入对象
//
//        System.out.println("请输入一个整数");
//        int x= scan.nextInt();
//        System.out.println(x);
        List<String> strs1 = new ArrayList<String>() {{
            add("c");
        }};
        List<String> strs = new ArrayList<String>() {{
            add("a");
            add("b");
            addAll(strs1);

        }};


        strs.add("哈哈哈");
        for (int i = 0; i < strs.size(); i++) {
            String s = strs.get(i);
            System.out.println(s);
            //((String) s)
            //String.format(s, )
//            if (s != null) {
//
//            }
//            try {
//                s
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            final String ss = s;
            String.format(s, "");
        }
        System.out.println(strs.size());
        Map<String, String> map1 = new HashMap<>();
        map1.put("xjtu", "good");

//        for (String key : map1.keySet()) {
//
//            System.out.println("Key = " + key + "d");
//
//        }
//        for (Map.Entry<String, String> entry : map1.entrySet()) {
//
//            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//
//        }

        int[] arra=new int[3];
        arra[0]=1;
        arra[1]=2;
        arra[2]=3;
//        arra[3]=4;
        System.out.println(arra);//打印的是地址
        System.out.println(arra[2]);
    }
}

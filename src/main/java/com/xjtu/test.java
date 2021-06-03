package com.xjtu;

import com.xjtu.ssmidea.jianzhioffer.Node;
import com.xjtu.ssmidea.jianzhioffer.TreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @auther coraljiao
 * @date 2020/3/31 14:06
 * @description
 */
public class test {
    static int[] count = new int[10];
    static int max = -1;

    public static void main(String[] args) throws IOException {
//用线程池来实现 ，3个线程加入线程池
//        ExecutorService pool = Executors.newSingleThreadExecutor();
//
//        for (int i = 0; i < 10; i++) {
//            pool.submit(()-> System.out.println("AAAAAA"));
//            pool.submit(()-> System.out.println("BBBBBB"));
//            pool.submit(()-> System.out.println("CCCCCC"));
//        }
//        pool.shutdown();

        //
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);
//        treeNode.right = new TreeNode(3);
//        treeNode.left.left = new TreeNode(4);
//        treeNode.left.right = new TreeNode(5);
//        treeNode.right.left = new TreeNode(6);
//        treeNode.right.right = new TreeNode(7);
//
//        width(treeNode, 0);
//        System.out.println(max);

        //str();

//        Integer[] arr = {5,1,2,6,7,8,93,67,11,3,87,4,6,12,45,86};
//        flushArr(arr);
//        for(int num : arr){
//            System.out.print(num + " ");
//        }

        Node a1=new Node(1);
        Node a2=new Node(2);
        Node a3=new Node(3);
        Node a4=new Node(4);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;

        Node a5=new Node(3);
        Node node = removeNode(a1, a2);
        System.out.println(node.val);
    }


    public static void width(TreeNode root, int k) {
        if (root == null) return;
        count[k]++;
        if (max < count[k]) {
            max = count[k];
        }
        width(root.left, k + 1);
        width(root.right, k + 1);
    }

    public static void flushArr(Integer[] arr){
        int length = arr.length;

        int index = length - 1;

        for(int i = 0; i < length && index > 0 ; i++){
            int num = createRandom(index);
            int temp = arr[num];
            arr[num] = arr[index];
            arr[index] = temp;
            index--;
        }
    }

    public static int createRandom(int end){
        return (new Random().nextInt(end));
    }

    public static Node removeNode(Node head, Node toRemove){
        if (toRemove.next != null) {
            Node toRemoveNext = toRemove.next;
            toRemove.val = toRemoveNext.val;
            toRemove.next = toRemoveNext.next;
            return head;
            // 尾节点
        }
        return head;
    }

    public static void str() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String regEx="[a-zA-Z]"; //
        Pattern p= Pattern.compile(regEx);
        String str="www.toutiao.com/p/index.html";
        String[] str2=str.split("\\.|/");//存放字符串
        Matcher m=p.matcher(str);
        str=m.replaceAll("");
        char[] fuhao=str.toCharArray();//存放符号
        int len=fuhao.length;
        char temp;
        for(int i=0;i<len/2;i++){
            temp=fuhao[len-1-i];
            fuhao[len-1-i]=fuhao[i];
            fuhao[i]=temp;
        }

        int len2=str2.length;
        String temp2=null;
        for(int i=0;i<len2/2;i++){
            temp2=str2[len2-1-i];
            str2[len2-1-i]=str2[i];
            str2[i]=temp2;
        }

        for(int i=0,j=0;i<len2||j<len;i++,j++) {
            System.out.print(str2[i]);
            if(j==len) continue;
            System.out.print(fuhao[j]);
        }
        br.close();
    }
}

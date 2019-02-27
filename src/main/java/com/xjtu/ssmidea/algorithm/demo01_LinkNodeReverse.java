package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/2/27 11:10
 * @description
 */
public class demo01_LinkNodeReverse {
    public static void main(String[] args){

    }
    //定义一个节点类
    class Node {
        int index;
        Node node;
        public Node(int index,Node node){
            this.index=index;
            this.node=node;
        }
    }
    //1）迭代法。先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点

}

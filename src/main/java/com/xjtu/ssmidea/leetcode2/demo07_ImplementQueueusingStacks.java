package com.xjtu.ssmidea.leetcode2;

import java.util.Stack;

/**
 * @auther coraljiao
 * @date 2018/12/29 21:30
 * @description
 */
//使用堆栈实现队列
//    使用堆栈实现队列的以下操作。 push（x） - 将元素x推送到队列的后面。 pop（） - 从队列前面删除元素。 peek（） - 获取前面的元素。 empty（） - 返回队列是否为空。
public class demo07_ImplementQueueusingStacks {
    public static void main(String[] args){

    }


}
class MyQueue {

    Stack<Integer> input = new Stack();  //进
    Stack<Integer> output = new Stack(); //出

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() { //反转
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}


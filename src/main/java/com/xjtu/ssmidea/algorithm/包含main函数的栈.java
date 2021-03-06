package com.xjtu.ssmidea.algorithm;

import java.util.Stack;

/**
 * @auther coraljiao
 * @date 2019/3/5 20:22
 * @description
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 *
 * 利用一个辅助栈来存放最小值
 *
 * 栈  3，4，2，5，1
 *
 * 辅助栈 3，3，2，2，1
 *
 * 每入栈一次，就与辅助栈顶比较大小，如果小就入栈，如果大就入栈当前的辅助栈顶
 * 当出栈时，辅助栈也要出栈
 *
 * 栈3 辅助栈入3，
 *
 * 栈4，辅助栈栈顶比4小入3，
 *
 * 栈入2，辅助栈栈顶是3比2大所以入2，每次都是把栈顶与入栈的值比较，入那个最小的，这样栈顶一直最小。
 */
public class 包含main函数的栈 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public static void main(String[] args){

    }
    public void push(int node) {
        stack1.push(node);
        if(stack2.empty())
        {
            stack2.push(node);
        }else{
            if(node <= (int)stack2.peek()) //这个if/else是比较栈顶与入栈的值，哪个小入哪个
                stack2.push(node);
            else{
                stack2.push(stack2.peek());
            }
        }
    }
    public void pop() {
        stack2.pop();//出栈是都出栈的
        stack1.pop();
    }

    public int top() {
        return (int)stack1.peek();
    }

    public int min() {
        return (int)stack2.peek();//栈2是辅助栈，每次都是最小值
    }

}

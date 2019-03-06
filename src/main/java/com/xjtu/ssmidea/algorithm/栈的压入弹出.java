package com.xjtu.ssmidea.algorithm;

import java.util.Stack;

/**
 * @auther coraljiao
 * @date 2019/3/5 20:43
 * @description
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 *
 * 一个弹出序列，一个压栈序列，弹出序列中的数，比如第一个弹出的数，肯定是在压栈过程中弹出来的，所以在这里新建一个栈stack,如果压栈序列中要压入的数和弹出序列当前的数不一样（说明没找到），那么压栈序列继续压，直到压栈序列中找到了和弹出序列当前下标值相等的数，那么弹出序列的下标值就+1,。
 *
 * 结束条件就是弹出序列的下标值可以到达序列的末尾。
 */
public class 栈的压入弹出 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //pushA压栈  popA出栈
        if(pushA.length != popA.length)
            return false;
        Stack<Integer> stack1 = new Stack<>();//栈记录压栈
        int j = 1;
        stack1.push(pushA[0]);//栈中先压入push压栈序列的第一个数
        for(int i=0;i<popA.length;i++)
        {
            //peek()函数返回栈顶的元素，但不弹出该栈顶元素。
            // //pop()函数返回栈顶的元素，并且将该栈顶元素出栈。
            while(j < pushA.length && stack1.peek() != popA[i])
            {//如果栈顶的数和弹出序列不一样，就一直压栈，因为必须是从栈顶弹出的！
                stack1.push(pushA[j]);
                j++;
            }
            if(j >= pushA.length && stack1.peek() != popA[i])
                return false;//如果j已经到达压栈序列的末尾，但是栈顶的数还是和弹出序列当前的数不一致
            //说明没有这个序列
            stack1.pop();
        }
        return true;
    }
}

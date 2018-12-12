package com.xjtu.ssmidea.leetcode;

import java.util.HashMap;
import java.util.Map;

public class demo25_CountBinarySubstrings {
    /*符合要求的子字符串要求0和1同时出现，那么当第一个1出现的时候，前面由于前面有两个0，所以肯定能组成01，再遇到下一个1时，此时1有2个，0有2个，能组成0011，下一个遇到0时，此时0的个数重置为1，而1的个数有两个，所以一定有10，同理，下一个还为0，就会有1100存在，之后的也是这样分析。那么我们可以发现我们只要分别统计0和1的个数，而且如果当前遇到的是1，那么只要之前统计的0的个数大于当前1的个数，就一定有一个对应的子字符串，而一旦前一个数字和当前的数字不一样的时候，那么当前数字的计数要重置为1。所以我们遍历元数组，如果是第一个数字，那么对应的ones或zeros自增1。然后进行分情况讨论，如果当前数字是1，然后判断如果前面的数字也是1，则ones自增1，否则ones重置为1。如果此时zeros大于ones，res自增1。反之同理，如果当前数字是0，然后判断如果前面的数字也是0，则zeros自增1，否则zeros重置为1。如果此时ones大于zeros，res自增1
      int zeros = 0, ones = 0, res = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (i == 0) {
                (s[i] == '1') ? ++ones : ++zeros;
            } else {
                if (s[i] == '1') {
                    ones = (s[i - 1] == '1') ? ones + 1 : 1;
                    if (zeros >= ones) ++res;
                } else if (s[i] == '0') {
                    zeros = (s[i - 1] == '0') ? zeros + 1 : 1;
                    if (ones >= zeros) ++res;
                }
            }
        }
        return res;
    * */
    public static void main(String[] args) {
        String s = "00100";
        int res = countBinarySubstrings4(s);
        System.out.println(res);
    }

    private static int countBinarySubstrings4(String s) {
        if(s.length() <= 1) return 0;
        int curCount = 1, preCount = 0, result = 0;
        char[] cs = s.toCharArray();
        for(int i = 1;i < cs.length;i++) {
            if(cs[i] == cs[i - 1]) curCount++;
            else {
                result += Math.min(curCount, preCount);
                preCount = curCount;
                curCount = 1;
            }
        }

        return result + Math.min(curCount, preCount);
    }

    private static int countBinarySubstrings3(String s) {
        int cur = 1, pre = 0, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) cur++;
            else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        return res + Math.min(cur, pre);
    }
    //pre和cur两个变量，其中pre初始化为0，cur初始化为1，然后从第二个数字开始遍历，如果当前数字和前面的数字相同，则cur自增1，否则pre赋值为cur，cur重置1。然后判断如果pre大于等于cur，res自增1。其实核心思想跟上面的方法一样，只不过pre和cur可以在0和1之间切换
        //直接遍历一次通过交换两个相邻连续子串长度的方法，每次res只加1，而不是加相邻计数的较小值
    private static int countBinarySubstrings2(String s) {
        int prevRunLength = 0, curRunLength = 1, res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) curRunLength++;//如果相同则++
            else {
                prevRunLength = curRunLength;
                curRunLength = 1;
            }
            //如果左边的子串长度一直大于后边的则++
            if (prevRunLength >= curRunLength) res++;
        }
        return res;
    }

    public static int countBinarySubstrings(String s) {
        if (s.length() == 0) return 0;
        int sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.size() % 2 == 0 && (map.get('0') == map.get('1'))) {//偶数个
                sum++;
                //map.clear();
                //i--;
            } else {
                if (map.size() > 1 && (Math.abs(map.get('0') - map.get('1')) == 1)) {
                    sum++;
                }
            }
        }
        return sum;
    }


}

package com.xjtu.ssmidea.leetcode2;

import java.util.List;

/**
 * @auther coraljiao
 * @date 2018/12/28 19:56
 * @description
 */
public class demo04_MaximumDepthofNaryTree {
    public static void main(String[] args) {

    }

    public int maxDepth(Node root) {
        int height = 0;
        if (root == null) {
            height = 0;
        } else {
            if (root.children.size() > 0) {
                height += maxDepth(root.children.get(0));
            } else {
                height = 1;
            }
        }


        return height;
    }

    public int maxDepth2(Node root) {

        if(root == null){
            return 0;
        }
        int depth = 0;
        for(Node node:root.children){
            depth = Math.max(depth,maxDepth2(node));//取当前node的最大值
        }

        return depth + 1;
    }

    //    private int max = 0;
    //    public int maxDepth(Node root) {
    //        if(root == null) return 0;
    //        dfs(root, 1);
    //        return max;
    //    }
    //
    //    public void dfs(Node root, int depth) {
    //        max = Math.max(max, depth);
    //        for(Node node : root.children) {
    //            dfs(node, depth+1);
    //        }
    //    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


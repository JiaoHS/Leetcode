package com.xjtu.ssmidea.algorithm;

/**
 * @auther coraljiao
 * @date 2019/3/5 10:58
 * @description
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构
 */
public class 树的子结构 {
    public static void main(String[] args){

    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null)//当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
            return false;
        if(root1 == null)
            return false;
        boolean flag = false;
        if(root1.val == root2.val)//以这个根节点为为起点判断是否包含Tree2
        {
            flag = doHasSubtree(root1,root2);
        }
        if(flag)
            return flag;
        if(!flag)
        {//如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            flag = HasSubtree(root1.left,root2);
            if(flag)
                return true;
            else{//如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
                flag = HasSubtree(root1.right,root2);
                if(flag)
                    return true;
            }
        }
        return false;
    }
    private boolean doHasSubtree(TreeNode root1,TreeNode root2)
    {
        if(root2 == null)//如果Tree2已经遍历完了都能对应的上，返回true
            return true;
        if(root1 == null)//如果Tree2还没有遍历完，Tree1却遍历完了。返回false
            return false;
        if(root1.val != root2.val)//如果其中有一个点没有对应上，返回false
            return false;
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doHasSubtree(root1.left,root2.left) && doHasSubtree(root1.right,root2.right);
    }
}

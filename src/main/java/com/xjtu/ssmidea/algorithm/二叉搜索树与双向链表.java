package com.xjtu.ssmidea.algorithm;

import java.util.ArrayList;

/**
 * @auther coraljiao
 * @date 2019/3/8 16:58
 * @description
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *
 * 先中序遍历二叉搜索树，这样二叉搜索树就按照val值的大小从小到大排好序了，存放在数组中 *
 * 然后要转换为双向链表，由于数组中的存放的树的节点已经按照键值从小到大排好序了，那么就对于每个节点的左子树指向数组的上一个节点，右子树指向数组的下一个节点，这样就完成了变成双向链表。
 */
public class 二叉搜索树与双向链表 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null || (pRootOfTree.left == null && pRootOfTree.right == null))
            return pRootOfTree;
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        BuildArrayList(pRootOfTree,nodeList);//这个函数执行后，数组中每个元素按照大小前后排序
        for(int i=0;i<nodeList.size();i++)
        {
            if(i == 0)
            {//数组的第一个节点处理，只有右子树指向下一个节点
                nodeList.get(0).right = nodeList.get(1);
            }
            else if(i == nodeList.size()-1)
            {//数组的最后一个节点，只有左子树指向前一个节点
                nodeList.get(i).left = nodeList.get(i-1);
            }
            else{//数组中的中间节点，左子树指向上一个节点，右子树指向数组的下一个节点
                nodeList.get(i).left = nodeList.get(i-1);
                nodeList.get(i).right = nodeList.get(i+1);
            }
        }
        return nodeList.get(0);
    }
    public void BuildArrayList(TreeNode root,ArrayList<TreeNode> nodeList)
    {//二叉搜索的中序遍历，并把每个节点存入数组中
        if(root == null)
            return;
        if(root.left != null)//左子树
            BuildArrayList(root.left,nodeList);
        if(root != null)//根节点
            nodeList.add(root);
        if(root.right != null)//右子树
            BuildArrayList(root.right,nodeList);
    }
}

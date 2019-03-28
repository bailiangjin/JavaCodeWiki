package com.blj.javawiki.algorithm.binarytree;



/**
 * Created by bailiangjin on 2017/7/1.
 */
public class BinaryTreeDemo {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, "root");
        TreeNode nodeA = new TreeNode(2, "nodeA");
        TreeNode nodeB = new TreeNode(3, "nodeB");
        TreeNode nodeC = new TreeNode(4, "nodeC");
        TreeNode nodeD = new TreeNode(5, "nodeD");
        TreeNode nodeE = new TreeNode(6, "nodeE");
        TreeNode nodeF = new TreeNode(7, "nodeF");

        root.leftChild=nodeA;
        root.rightChild=nodeB;

        root.leftChild.leftChild=nodeC;
        root.leftChild.rightChild=nodeD;

        root.rightChild.leftChild=nodeE;
        root.rightChild.rightChild=nodeF;

        postOrderVisit(root);


    }

    public static void inOrderVisit(TreeNode subTree){
        if(null!=subTree){
            inOrderVisit(subTree.leftChild);
            visted(subTree);
            inOrderVisit(subTree.rightChild);
        }

    }


    public static void preOrderVisit(TreeNode subTree){
        if(null!=subTree){
            visted(subTree);
            preOrderVisit(subTree.leftChild);
            preOrderVisit(subTree.rightChild);
        }

    }

    public static void postOrderVisit(TreeNode subTree){
        if(null!=subTree){
            postOrderVisit(subTree.leftChild);
            postOrderVisit(subTree.rightChild);
            visted(subTree);
        }

    }

    public static void visted(TreeNode subTree){
        subTree.isVisted=true;
        System.out.println("key:"+subTree.key+"--name:"+subTree.data);;
    }


    /**
     * 二叉树的节点数据结构
     *
     * @author WWX
     */
    public static class TreeNode {
        private int key = 0;
        private String data = null;
        private boolean isVisted = false;
        private TreeNode leftChild = null;
        private TreeNode rightChild = null;

        public TreeNode() {
        }

        /**
         * @param key  层序编码
         * @param data 数据域
         */
        public TreeNode(int key, String data) {
            this.key = key;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }
}

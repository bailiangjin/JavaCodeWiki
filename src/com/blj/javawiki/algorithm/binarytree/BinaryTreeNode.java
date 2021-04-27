package com.blj.javawiki.algorithm.binarytree;

/**
 * 二叉树实例
 *
 * @author bailiangjin
 * @date 2018/9/9
 */
public class BinaryTreeNode<T> {

    /**
     * 结点值
     */
    public T value;

    /**
     * 左子树
     */
    public BinaryTreeNode left;

    /**
     * 右子树
     */
    public BinaryTreeNode right;


    public BinaryTreeNode(T value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

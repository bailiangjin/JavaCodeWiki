package com.blj.javawiki.algorithm.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树 接口
 *
 * @author bailiangjin
 * @date 2018/9/9
 */
public interface IBinaryTree<T extends Object> {

    /**
     * 1
     * root1是否包含root2 子树
     *
     * @param root1
     * @param root2
     * @return
     */
    boolean hasSubtree(BinaryTreeNode<T> root1, BinaryTreeNode<T> root2);

    /**
     * 前序遍历 非递归
     * @param root
     * @return
     */
    List<Integer> preOrderTraversalNoRecursion(BinaryTreeNode root);

    /**
     * 2
     * 前序遍历 二叉树
     *
     * @param root
     */
    void preOrderTraversal(BinaryTreeNode<T> root);


    /**
     * 3
     * 中序遍历二叉树
     *
     * @param root
     */
    void inorderTraversal(BinaryTreeNode<T> root);


    /**
     * 中序遍历 非递归
     * @param root
     * @return
     */
    List<Integer> inorderTraversalNoRecursion(BinaryTreeNode root);

    /**
     * 4
     * 后序遍历二叉树
     *
     * @param root
     */
    void postOrderTraversal(BinaryTreeNode<T> root);

    /**
     * 后序遍历 非递归
     * @param root
     * @return
     */
    List<T> postOrderTraversalNoRecursion(BinaryTreeNode<T> root);

    /**
     * 5
     * 按层从左向右遍历树
     * @param root
     */
    void levelOrderTraversal(BinaryTreeNode<T> root);

    /**
     * 6
     * 反转二叉树
     *
     * @param root
     */
    void mirror(BinaryTreeNode<T> root);

    /**
     * 7
     * 是否互为镜像
     *
     * @param t1
     * @param t2
     * @return
     */
    boolean isMirror(BinaryTreeNode<T> t1, BinaryTreeNode<T> t2);

    /**
     * 8
     * 是否为两个相同的二叉树
     *
     * @param t1
     * @param t2
     * @return
     */
    boolean isSame(BinaryTreeNode<T> t1, BinaryTreeNode<T> t2);

    /**
     * 9
     * 求二叉树的最大深度
     *
     * @param root
     * @return
     */
    int getMaxDepth(BinaryTreeNode<T> root);

    /**
     * 10
     * 求二叉树的最小深度
     *
     * @param root
     * @return
     */
    int getMinDepth(BinaryTreeNode<T> root);

    /**
     * 11
     * 计算二叉树的 结点数
     *
     * @param root
     * @return
     */
    int countNumOfTreeNode(BinaryTreeNode<T> root);

    /**
     * 12
     * 计算二叉树的叶子结点
     *
     * @param root
     * @return
     */
    int countNumberOfNoChildNode(BinaryTreeNode<T> root);

    /**
     * 13
     * 计算第k层 结点数量
     *
     * @param root
     * @param k
     * @return
     */
    int numOfkLevelTreeNode(BinaryTreeNode<T> root, int k);

    /**
     * 14
     * 判断是否为平衡二叉树
     * @param root
     * @return
     */
    boolean isBalanced(BinaryTreeNode<T> root);


    /**
     * 15
     * 是否为满二叉树
     * @param root
     * @return
     */
    boolean isCompleteBinaryTree(BinaryTreeNode<T> root);

    /**
     * 16
     * 是否为满二叉树
     * @param root
     * @return
     */
    boolean isFullBinaryTree(BinaryTreeNode<T> root);

    /**
     * 17
     * 在有序二叉树中插入结点
     * @param root
     * @param node
     * @return
     */
    BinaryTreeNode insertNode(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node);



}

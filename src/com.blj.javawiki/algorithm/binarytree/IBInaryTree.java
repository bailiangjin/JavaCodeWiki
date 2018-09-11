package com.blj.javawiki.algorithm.binarytree;

/**
 * 二叉树 接口
 *
 * @author bailiangjin
 * @date 2018/9/9
 */
public interface IBInaryTree {

    /**
     * root1是否包含root2 子树
     *
     * @param root1
     * @param root2
     * @return
     */
    boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2);

    /**
     * 前序遍历 二叉树
     *
     * @param root
     */
    void preOrderTraversal(BinaryTreeNode root);


    /**
     * 中序遍历二叉树
     *
     * @param root
     */
    void inorderTraversal(BinaryTreeNode root);


    /**
     * 后序遍历二叉树
     *
     * @param root
     */
    void postOrderTraversal(BinaryTreeNode root);

    /**
     * 反转二叉树
     *
     * @param root
     */
    void mirror(BinaryTreeNode root);

    /**
     * 是否互为镜像
     * @param t1
     * @param t2
     * @return
     */
    boolean isMirror(BinaryTreeNode t1,BinaryTreeNode t2);

    /**
     * 是否为两个相同的二叉树
     * @param t1
     * @param t2
     * @return
     */
    boolean isSameTreeNode(BinaryTreeNode t1,BinaryTreeNode t2);

    /**
     * 求二叉树的最大深度
     *
     * @param root
     * @return
     */
    int getMaxDepth(BinaryTreeNode root);

    /**
     * 求二叉树的最小深度
     *
     * @param root
     * @return
     */
    int getMinDepth(BinaryTreeNode root);

    /**
     * 计算二叉树的 结点数
     *
     * @param root
     * @return
     */
    int countNumOfTreeNode(BinaryTreeNode root);

    /**
     * 计算二叉树的叶子结点
     * @param root
     * @return
     */
    int countNumberOfNoChildNode(BinaryTreeNode root);

}

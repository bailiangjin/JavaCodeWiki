package com.blj.javawiki.algorithm.binarytree;

import java.util.*;

/**
 * 二叉树 算法实例
 *
 * @author bailiangjin
 * @date 2018/9/9
 */
public class BinaryTreeNodeImpl implements IBinaryTree1<Integer> {
    @Override
    public boolean hasSubtree(BinaryTreeNode root1, BinaryTreeNode root2) {

        if (null == root1 || null == root2) {
            return false;
        }

        boolean result = false;

        if (root1.value == root2.value) {
            result = isTree1HasTree2(root1, root2);
        }

        if (!result) {
            result = hasSubtree(root1.left, root2);
        }

        if (!result) {
            result = hasSubtree(root1.right, root2);
        }

        return result;
    }


    public boolean isTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (null == root2) {
            return true;
        }

        if (null == root1) {
            return false;
        }

        if (root1.value != root2.value) {
            return false;
        }

        return isTree1HasTree2(root1.left, root2.left)
                && isTree1HasTree2(root1.right, root2.right);
    }


    @Override
    public ArrayList<Integer> preOrderTraversalNoRecursion(BinaryTreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            BinaryTreeNode node = stack.pop();
            list.add((Integer) node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
        return list;
    }

    /**
     * 非递归后序遍历
     *
     * @param root
     */
    @Override
    public List<Integer> postOrderTraversalNoRecursion(BinaryTreeNode root) {
        List<Integer> rstList = new ArrayList();
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (root == null) {
            return rstList;
        }

        BinaryTreeNode curNode = null;
        BinaryTreeNode pre = null;
        stack.push(root);
        while (!stack.empty()) {
            curNode = stack.peek();
            if ((curNode.left == null && curNode.right == null)
                    || (pre != null && (curNode.left == pre || curNode.right == pre))) {
                BinaryTreeNode temp = stack.pop();
                rstList.add((Integer) temp.value);
                pre = temp;
            } else {
                if (curNode.right != null) {
                    stack.push(curNode.right);
                }
                if (curNode.left != null) {
                    stack.push(curNode.left);
                }
            }
        }
        return rstList;
    }


    /**
     * 中序遍历 非递归
     *
     * @param root
     * @return
     */
    @Override
    public List<Integer> inorderTraversalNoRecursion(BinaryTreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;
        while (current != null || !stack.empty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            list.add((Integer) current.value);
            current = current.right;

        }
        return list;
    }


    /**
     * 先序遍历
     *
     * @param root
     */
    @Override
    public void preOrderTraversal(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    @Override
    public void inorderTraversal(BinaryTreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.value);
            inorderTraversal(root.right);
        }
    }

    /**
     * 后序遍历
     *
     * @param root
     */
    @Override
    public void postOrderTraversal(BinaryTreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.value);
        }
    }

    @Override
    public void levelOrderTraversal(BinaryTreeNode root) {
        if (root == null) {
            System.out.println("输入为空树");
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("开始分层遍历树");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = ((LinkedList<BinaryTreeNode>) queue).removeFirst();
                System.out.print(node.value + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

//                if(null==node.left&&null==node.right){
//                    System.out.print("\t");
//                }
            }
            System.out.println();
        }

        System.out.println("结束分层遍历树");
    }

    @Override
    public void mirror(BinaryTreeNode root) {
        if (null == root) {
            return;
        }

        if (null == root.left && null == root.right) {
            return;
        }

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirror(root.left);
        mirror(root.right);

    }

    @Override
    public boolean isMirror(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (null == t1 && null == t2) {
            return true;
        }

        if (null == t1 || null == t2) {
            return false;
        }

        if (t1.value == t2.value) {
            return true;
        }

        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    @Override
    public boolean isSame(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (null == t1 && null == t2) {
            return true;
        }

        if (null == t1 || null == t2) {
            return false;
        }

        if (t1.value == t2.value) {
            return true;
        }

        return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
    }


    /**
     * @param root
     * @return
     */
    @Override
    public int getMaxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    @Override
    public int getMinDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMinDepth(root.left);
        int right = getMinDepth(root.right);
        return Math.min(left, right) + 1;
    }

    @Override
    public int countNumOfTreeNode(BinaryTreeNode root) {
        if (root == null) {
            return 0;

        }
        int left = countNumOfTreeNode(root.left);
        int right = countNumOfTreeNode(root.right);
        return left + right + 1;
    }


    @Override
    public int countNumberOfNoChildNode(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        return countNumberOfNoChildNode(root.left) + countNumberOfNoChildNode(root.right);

    }

    @Override
    public int numOfkLevelTreeNode(BinaryTreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int numOfLeft = numOfkLevelTreeNode(root.left, k - 1);
        int numOfRight = numOfkLevelTreeNode(root.right, k - 1);
        return numOfLeft + numOfRight;
    }

    @Override
    public boolean isBalanced(BinaryTreeNode root) {
        if (null == root) {
            return true;
        }
        if (null == root.left && null == root.right) {
            return true;
        }

        if (null != root.left && null != root.right) {
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return false;
    }

    @Override
    public boolean isCompleteBinaryTree(BinaryTreeNode<Integer> root) {
        if (null == root) {
            return false;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean isHasNoChild = false;
        while (!queue.isEmpty()) {
            BinaryTreeNode currentNode = ((LinkedList<BinaryTreeNode>) queue).removeFirst();

            if (isHasNoChild) {
                if (null != currentNode.left || null != currentNode.right) {
                    return false;
                }
            } else {
                if (null == currentNode.left) {
                    if (null != currentNode.right) {
                        return false;
                    } else {
                        isHasNoChild = true;
                    }
                } else {
                    queue.add(currentNode.left);
                    if (null != currentNode.right) {
                        queue.add(currentNode.right);
                    } else {
                        isHasNoChild = true;
                    }

                }
            }
        }
        return true;
    }

    @Override
    public boolean isFullBinaryTree(BinaryTreeNode root) {

        if (null == root) {
            return false;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode currentNode = ((LinkedList<BinaryTreeNode>) queue).removeFirst();

            if (null == currentNode.left && null != currentNode.right || null != currentNode.left && null == currentNode.right) {
                return false;
            }

            if (null != currentNode.left && null != currentNode.right) {
                queue.add(currentNode.left);
                queue.add(currentNode.right);
            }
        }

        return true;

    }

    @Override
    public BinaryTreeNode insertNode(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
        if (root == node) {
            return node;
        }
        BinaryTreeNode tmp = root;
        BinaryTreeNode last = null;
        while (tmp != null) {
            last = tmp;
            if ((int) tmp.value > (int) node.value) {
                tmp = tmp.left;
            } else {
                tmp = tmp.right;
            }
        }
        if (last != null) {
            if ((int) last.value > (int) node.value) {
                last.left = node;
            } else {
                last.right = node;
            }
        }
        return root;
    }


}



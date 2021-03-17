package Java_2021_03_17;

class Node{
    // 设置属性
    public int val;
    public Node left;
    public Node right;
    // 对值进行构造


    public Node(int val) {
        this.val = val;
    }
}

public class binaryTreeIsBalance {
    // 题目要求：判断一个二叉树是否是平衡二叉树
    // 基本思想：平衡二叉树值的是，左右子树的高度差不超过1，递归求左右子树的高度，并进行做差比较，最后进行判断
    // 求树的高度代码：
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }
    public static boolean isBalance(Node root) {
        // 1.特殊情况处理
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        // 2.一般情况处理
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if ((leftHeight - rightHeight) > 1 || (leftHeight - rightHeight) < -1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
}

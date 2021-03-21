package java_2021_03_21;

import java.util.Stack;

public class MyPostOrder {
    // 题目要求：非递归实现后序遍历二叉树
    public static void postOrderNoR(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;// 用来记录后序遍历中的前一个节点
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 判断cur 是否能被访问
            if (stack.isEmpty()) {
                break;
            }
            TreeNode top = stack.peek();// 用peek的原因是，不能判定此时是否能被访问,这里只是判断一下
            if (top.right == null || prev == top.right) {
                System.out.print(top.val);
                stack.pop();
                prev = top;
            } else {// 要是访问不了，重复前边的过程
                cur = top.right;
            }
        }
    }
}

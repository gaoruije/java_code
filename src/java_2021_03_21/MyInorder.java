package java_2021_03_21;

import java.util.Stack;

public class MyInorder {
    // 题目要求：非递归实现中序遍历二叉树
    public static void inOrderNoR(TreeNode root) {
        // 1.还是先创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        // 2.创建一个 cur 从root出发，连续找左子树，一直入栈，直到空为止。
        TreeNode cur = root;
        // 3.进行循环，外层循环负责从栈里边往外拿元素，内层循环负责往左走，向栈里边插元素
        while (true) {
            // 控制的是一直给栈里边插入元素
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {// 要是栈是空的，就返回了
                break;
            }
            // 要是栈不是空的，取出栈顶元素，进行访问。
            // 取栈顶元素,要记录下来，后边要用这个节点的左右子树，不然不好表示
            TreeNode top = stack.pop();
            System.out.println(top.val);// 访问打印的是指，而不是一个节点
            // 让cur 指向top的右子树，重复执行上边的过程
            cur = top.right;
        }
    }
}

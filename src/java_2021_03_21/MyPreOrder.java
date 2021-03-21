package java_2021_03_21;

import java.util.Stack;

public class MyPreOrder {
    // 题目要求：自己使用非递归实现先序遍历二叉树
    // 核心：用栈来实现
    public static void preOrderNoR(TreeNode root) {
        // 1.先弄一个栈,辅助进行递归
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 2.将树根入栈
        stack.push(root);
        // 3.循环取出栈顶元素，不能弄那个while（true）
//        while (true) {
//            TreeNode cur = stack.pop();// 栈这里要是空的话，就直接抛异常了
//            if ()
//        }
        while (!stack.isEmpty()) {// 表示要是栈是非空的话，就进行循环
            TreeNode cur = stack.pop();
            // 访问改元素
            System.out.print(cur.val + " ");
            // 4.将左右子树入栈，注意顺序不能改变
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }
}

package Java_2021_03_16;

import java.util.LinkedList;
import java.util.Queue;

// 二叉树的构建
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

public class BinaryTreeHeight {
    // 1.手动构建一颗二叉树
    public static Node build() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        e.left = g;
        return a;
    }

    // 2.先序遍历二叉树
    public static void preOrder(Node root) {
        // 特殊情况的处理
        if (root == null) {
            return;
        }
        // 一般情况的处理
        // 先打印根节点
        System.out.print(root.val + " ");
        // 递归遍历左子树
        preOrder(root.left);
        preOrder(root.right);
    }

    // 3.求一颗二叉树的高度
    // 基本思想：用1 + 左右子树高度的最大值
    // 先处理根节点，最后递归处理左右子树
    public static int treeHeight (Node root) {
        // 特殊情况
        if (root == null) {
            return 0;
        }
        // 一般情况的处理
        // 要是出现了左右子树没有子树的时候就返回1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // 递归处理左右子树,将较大的值加在根节点上
        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        // 进行判断，加上较大的值
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    // 测试前边写的代码：
    public static void main(String[] args) {
        Node root = build();
        //preOrder(root);
        //System.out.print("二叉树的高度是：" + treeHeight(root));
    }
}


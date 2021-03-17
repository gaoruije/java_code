package Java_2021_03_14;

import java.util.LinkedList;
import java.util.Queue;

public class judgeCompleteBinaryTree {

    // 题目要求：判断一个二叉树是否是完全二叉树
    // 基本思想：借助层序遍历来进行完成,分成两个阶段，一阶段里边有四种情况，二阶段里边有两种情况
    // 通过层序遍历找反例，要是存在反例，就返回false，遍历完成时还没有反例，就返回true
    public static boolean completeBinaryTree(Node root) {
        // 1.特殊情况处理
        if (root == null) {
            return true;
        }
        // 2.分阶段进行处理，我们用一个变量来表示
        boolean isLevel2 = false;// 表示第一阶段
        // 3.进行层序遍历，要借助一个队列
        Queue<Node> queue = new LinkedList<>();
        // 将树根进行入队列操作
        queue.offer(root);
        // 4.要循环处理每一轮
        while (true) {
            // 对刚入队列的元素进行出队列，并进行判断
            Node cur = queue.poll();
            if (cur == null) {// 说明队列里边是空了，直接返回
                break;
            }
            // 进行完上边的操作的时候，说明将队首元素取出来了，进行判断是第几阶段
            // 因为是从第一阶段进行的
            if (isLevel2) {// 要是是第一阶段
                // a)进入一阶段后，左右子树都存在
                if (root.left != null && root.right != null) {
                    // 直接进行入队
                    queue.offer(root.left);
                    queue.offer(root.right);
                } else if (root.left == null && root.right != null) {
                    // 左边子树是空，右边子树非空，一定不是完全二叉树
                    return false;
                } else if (root.left != null && root.right == null) {
                    // 左边子树不是空，右边子树是空。进入二阶段
                    isLevel2 = true;
                    // 并将不为空的子树入队列
                    queue.offer(root.left);
                } else {// 说明左右子树都是空的，进入二阶段
                    isLevel2 = true;
                }
            } else {// 下边的逻辑表示的是第二阶段的
                // 二阶段要求每个节点左右子树都是空才行
                if (root.left == null && root.right == null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        // 5.要是找完while循环还是没有反例的话，说明是完全二叉树
        return true;
    }
}


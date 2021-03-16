package Java_2021_03_16;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrder {
    // 题目要求：层序遍历二叉树
    // 基本思想：借助一个队列来完成
    public static void levelOrder(Node root) {
        // 1.先生成一个队列
        Queue<Node> queue = new LinkedList<>();// 队列是链表来实现的
        // 2.特殊情况的处理
        if (root == null) {
            return;
        }
        // 3.将树的根节点插入
        queue.offer(root);
        // 4.进行循环处理里边的所有节点
        while (true) {
            // 将队列中的元素出队列
            Node cur = queue.poll();
            if (cur == null) {// 说明队列已经是空的了，直接返回
                break;
            }
            // 5.要是不空就就进行访问，将队首元素打印出来。
            System.out.print(cur.val);
            // 6.将上边取出的元素的左右子树在进行重复操作
            if (cur.left != null) {// 要是左子树不是空的，就进行入队操作
                queue.offer(cur.left);
            }
            if (cur.right != null) {// 要是右子树不是空的就继续入队列
                queue.offer(cur.right);
            }
        }
    }
}

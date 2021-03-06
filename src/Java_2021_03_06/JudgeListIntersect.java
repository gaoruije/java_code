package Java_2021_03_06;

import static Java_2021_03_06.createNodeList.getLength;

public class JudgeListIntersect {
    // 题目要求：判断两个链表是否相交，要是相交返回交点，要是没有找到返回空
    // 基本思路：先求出两个链表的长度，让长的走短的长的减短的步数
    // 再创建两个引用来指向对其后的链表的头节点，以相同的速度来进行走，
    // 要是cur1和cur2相同了，就返回交点，要是出了循环还是没有相同的就没有交点
    public static Node judgeListIntersect(Node head1,Node head2) {
        // 1.求两个链表的长度
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        // 2.让长的先走，为了对齐方便后边进行比较节点
        if (length1 > length2) {
            int steps = length1 - length2;
            for (int i = 0; i < steps; i++) {
                head1 = head1.next;
            }
        } else {
            int step2 = length2 - length1;
            for (int i = 0; i < step2; i++) {
                head2 = head2.next;
            }
        }
        // 经过上边的循环后，两个链表就对齐了，下边来创建两个引用来比较
        while (head1 != null && head2 != null) {
            // 找到了,比较的是地址，而不是引用的值
            if (head1 == head2) {
                return head1;
            } else {// 没有找见，就向下继续找，更新两个引用
                head1 = head1.next;
                head2 =head2.next;

            }
        }
        // 上边的循环结束了，就说明没用公共节点
        return null;
    }
}

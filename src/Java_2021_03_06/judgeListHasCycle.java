package Java_2021_03_06;

public class judgeListHasCycle {
    // 题目要求：给定一个链表判断链表是否带环
    // 基本思路：快慢指针法，fast走两步，slow走一步
    // 要是fast和slow重合，则带环，不重合则不带环
    public static boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        // 让两个引用进行走步
        while (fast != null && fast.next != null) {// 因为fast是走两步的，所以对fast.next也进行判断
            fast = fast.next.next;
            slow = slow.next;
            // 进行判断看是否重合
            if (fast == slow) {
                return true;
            }
        }
        // 出了循环说明没有找见重合的，返回false
        return false;
    }
}

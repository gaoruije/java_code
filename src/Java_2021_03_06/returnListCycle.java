package Java_2021_03_06;

public class returnListCycle {
    // 题目要求：给定一个链表，要是链表带环，返回带环节点，要是不带环，返回null
    // 思路：快慢指针，先找到两个指针交汇的点，然后让一个cur1从头节点出发，一个节点从交汇点出发
    // 两个引用要是相交的会，就是带环的节点，不相交，则不带环
    public static Node returnListCycle(Node head) {
        // 1.设定快慢指针
        Node fast = head;
        Node slow = head;
        // 2.找交汇点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 这里不能直接返回节点,后边还是要用这个节点的
                break;
            }
        }
        // 3.判断出了循环的原因：出了上边的循环，一种是fast为空了，一种是找到交汇点了，下边进行判断一下
        if (fast != null && fast.next != null) {// 链表没有带坏
            return null;
        }
        // 4.下边就一定带环了，让两个引用来从头节点和交汇节点出发，要是相遇就返回节点
        Node cur1 = head;
        Node cur2 = fast;
        // 5.当两个引用不相等时，更新引用指向
        while (cur1 != cur2) {// 判断带环比较的是引用的值
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 出了循环说明，两个引用地址相同了，就是环的入口点
        return cur1;
    }
}

package Java_2021_03_05;

public class judgeListPalindromes {
    // 题目要求：给定一个链表，判断链表是否回文(就是正着看和反着看是否相同)
    // 思路：1.先将原链表A进行拷贝得到链表B
    // 2.将拷贝的链表B进行逆置
    // 3.将逆置后的链表和原链表进行比较看是否相同
    public static boolean chkPalindrome(Node head) {
        // 处理特殊情况
        if (head == null) {
            return true;
        }
        if (head.next == null) {
            return true;
        }
        // 处理一般情况
        // 1.先将原链表进行拷贝
        // 创建一个带傀儡节点的链表，并记录下尾节点，方便插入
        Node newHead = new Node(0);
        Node newTail = newHead;
        for (Node cur = head; cur != null; cur = cur.next) {
            // 进行尾插,创建一个新的节点不破坏原链表的结构
            newTail.next = new Node(cur.val);
            newTail = newTail.next;
        }
        // 将拷贝后的链表记为B
        Node B = newHead.next;
        // 2.将拷贝的链表B进行逆置
        // 创建三个引用来进行
        Node prev = null;
        Node cur = B;// 头节点的引用
        while (cur != null) {
            Node next = cur.next;
            // 进行逆置
            // 要是next指向空的时候，就是cur到达了链表的尾部，此时的cur就是逆置后的链表的新的头节点
            if (next == null) {
                B = cur;
            }
            cur.next = prev;
            // 更新引用指向
            prev = cur;
            cur = next;
        }
        // 3.将逆置后的链表和原链表进行比较看是否相同
        Node cur1 = head;
        Node cur2 = B;
        while (cur1 != null && cur2 != null) {
            // 举反例，判断不相等
            if (cur1.val == cur2.val) {
                return false;
            }
            // 更新cur的指向
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 走完循环，就是回文了
        return true;
    }
}

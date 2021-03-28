package java_2021_0328;


import Java_2021_02_22.ListNode;

public class LinkedListPractice {
    // 链表的构建
    public static Node createNode() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        return a;
    }

    // 1.链表的逆置
    public static Node reverseLinkedList(Node head) {
        // 特殊情况的处理
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 一般情况的处理，创建三个引用来进行改变引用之间的指向即可
        Node cur = head;
        Node prev = null;
        Node newHead = null;
        // 进行遍历链表
        while (cur != null) {
            Node next = cur.next;
            if (next == null) {
                newHead = cur;// 说明cur已经是最后一个节点了，也就是新的链表的头节点
            }
            // 要是不是最后一个元素就进行引用之间的改变
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return newHead;
    }

    // 2.删除链表中所有值是val的值
    public static Node removeAllVal(Node head,int val) {
        // 特殊情况的处理
        if (head == null) {
            return null;
        }
        // 一般情况处理
        Node prev = head;
        Node cur = head.next;
        // 先处理后边的所有节点
        while (cur != null) {
            if (cur != null && cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }
        // 再处理头节点
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    // 3.给定一个链表，返回链表的中间节点，要是偶数个，返回第二个节点
    public static int getLength(ListNode head) {
        int count = 0;
        ListNode cur = head;
        for (; cur != null; cur = cur.next) {
            count ++;
        }
        return count;
    }
    public ListNode middleNode(ListNode head) {
        // 特殊情况的处理
        if (head == null) {
            return null;
        }
        // 一般情况处理
        ListNode cur = head;
        int steps = getLength(head) / 2;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // 4.给定一个链表返回链表的倒数第K个节点
    public ListNode FindKthToTail(ListNode head,int k) {

        // 特殊情况的处理
        if (head == null){
            return null;
        }
        if (k <= 0){
            return null;
        }
        // 一般情况处理
        int length = getLength(head);
        if (length < k) {
            return null;
        }
        int steps = length - k;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

//    // 5.合并两个有序的链表
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        // 特殊情况处理
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        // 一般情况处理
//        // 先弄上一个带傀儡节点的链表，用来存排序的链表
//        ListNode newHead = new ListNode(0);
//        ListNode newTail = newHead;
//        ListNode cur1 = l1;
//        ListNode cur2 = l2;
//        while (cur1 != null && cur2 != null) {
//            if (cur1.val < cur2.val) {
//                // 插入cur1
//                newTail.next = new ListNode(cur1.val);
//                newTail = newTail.next;
//                cur1 = cur1.next;
//            } else {
//                // 插入cur2
//                newTail.next = new ListNode(cur2.val);
//                newTail = newTail.next;
//                cur2  = cur2.next;
//            }
//        }
//        // 循环完成后，看谁还没有被插入完全
//        while (cur1 != null) {
//            newTail.next = new ListNode(cur1.val);
//            newTail = newTail.next;
//            cur1 = cur1.next;
//        }
//        while (cur2 != null) {
//            newTail.next = new ListNode(cur2.val);
//            newTail = newTail.next;
//            cur2 = cur2.next;
//        }
//        // 结束之后，将链表返回
//        return newHead.next;
//    }

//    // 6.给定一个x，将链表中所有小于基准值的节点放在前边，将大于等于基准值的放在后边，
//    // 最后返回原排列好的链表
//    public ListNode partition(ListNode pHead, int x) {
//        // 特殊情况处理
//        if (pHead == null) {
//            return null;
//        }
//        if (pHead.next == null) {
//            return pHead;
//        }
//        // write code here
//        // 小的链表用来存小的节点
//        ListNode smallHead = new ListNode(0);
//        ListNode smallTail = smallHead;
//        // 大的链表用来存大的节点
//        ListNode largeHead = new ListNode(0);
//        ListNode largeTail = largeHead;
//        // 下来遍历链表
//        for (ListNode cur = pHead; cur != null; cur = cur.next) {
//            if (cur.val < x){
//                smallTail.next = new ListNode(cur.val);
//                smallTail = smallTail.next;
//            } else {
//                largeTail.next = new ListNode(cur.val);
//                largeTail = largeTail.next;
//            }
//        }
//        // 插入完成之后，将两个链表进行拼接
//        smallTail.next = largeHead.next;
//        return smallHead.next;
//    }
}

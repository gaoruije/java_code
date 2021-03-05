package Java_2021_03_05;

public class partition {
    // 题目要求：给定一个链表，并给定一个值x，建行链表中的所有小于x的值放在链表的前边，所有大于x的值放在后边
    // 思路：创建两个链表，smallList和largeList让带上傀儡节点，为了方便后边插入
    // 遍历链表，将小于x的放在小的链表里边，将大于的放在大的里边
    // 最后将两个链表进行拼接

    public static Node partition(Node head, int x) {
        // 处理特殊的处理
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 处理一般的情况，创建两个链表,让它带傀儡节点，为了方便进行插入，并记录尾节点
        Node smallHead = new Node(0);
        Node largeHead = new Node(0);
        // 记录尾节点，为了方便尾插
        Node smallTail = smallHead;
        Node largeTail = largeHead;
        // 遍历链表进行比较
        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                // 就给小链表中去插入,最好的方法是不破坏原链表,创建一个新的节点放入原链表中的值
                smallTail.next = new Node(cur.val);
                smallTail = smallTail.next;
            } else {
                // 就给大链表中去插入，还是不想破坏原链表的值，创建一个新的节点
                largeTail.next = new Node(cur.val);
                largeTail = largeTail.next;
            }
        }
        // 经过上边的循环就将链表拆分为两个链表了
        // 下边对两个链表进行拼接
        smallTail.next = largeHead.next;// 因为是带傀儡节点的,要将傀儡节点后边的那个值插入
        // 要返回那个新的链表，就要跨过傀儡节点
        return smallHead.next;
    }
}

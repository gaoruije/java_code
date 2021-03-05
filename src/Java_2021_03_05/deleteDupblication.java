package Java_2021_03_05;

public class deleteDupblication {
    // 题目要求：给定一个链表，删除链表中的所有重复的节点，重复的节点不保留，返回删除后的链表
    // 思路：创建一个链表，用来存原链表中的不重复的节点，最后返回这个新创建的链表
    // 遍历链表，要是发现有重复的节点，直接跳过，直到找到不重复的节点，插入到创建的链表中
    public static Node deleteAllNode(Node head) {
        // 先考虑特殊情况
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        // 处理一般情况，遍历链表
        // 创建保存结果的链表，让它是傀儡节点，并记录尾部位置
        Node newHead = new Node(0);
        Node newTail = newHead;
        // 遍历链表，进行比较相邻的值是否相等
        Node cur = head;
        while (cur != null) {
            // 比较相邻的值
            if (cur.next != null && cur.val == cur.next.val) {
                // 是重复节点，跳过,又因为重复节点不一定是一个，要就进行循环判定
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //出了里边的这个循环就说明，找到了那个不重复的节点了
                cur = cur.next;
            } else {// 不是重复节点，直接插入到创建的链表的里边即可
                // 还是为了不破坏原链表，创建一个新的节点来保存原链表中要插入的节点值
                newTail.next = new Node(cur.val);
                // 每次更新尾部
                newTail = newTail.next;
            }
            // 每一次循环结束后都要更新cur的指向
            cur = cur.next;
        }
        // 上边就已经将原链表找完了，返回新的链表的头节点
        return newHead.next;
    }
}

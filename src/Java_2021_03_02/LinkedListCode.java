package Java_2021_03_02;
public class LinkedListCode {
    // 创建链表
    public static Node createList() {
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

    public static void main(String[] args) {
        // 创建链表
        Node head = createList();
        // 1.遍历链表，打印每个元素
//        for (Node cur = head; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }
        // 2.找到链表的最后一个节点,cur.next是空的时候，cur就是最后一个了
//        Node cur = head;
//        for (;cur != null && cur.next != null; cur = cur.next) {
//
//        }
//        // 出了循环就说明cur 是最后一个了
//        System.out.println("最后一个节点是：" + cur.val);
        // 3.找到链表的倒数第二个节点
//        Node cur = head;
//        while (cur != null && cur.next != null && cur.next.next != null) {
//            cur = cur.next;
//        }
//        System.out.println("链表的倒数第二个节点是：" + cur.val);
        // 4.找链表中的第n个节点
//        int n = 4;
//        Node cur = head;
//        for (int i = 1; i < 4; i++) {
//            cur = cur.next;
//        }
//        System.out.println("第4个节点是：" + cur.val);
        // 5.计算链表中的元素个数
//        int count = 0;
//        // 注意要计算cur,当cur是null的时候，就不在计数了
//        for (Node cur = head; cur != null; cur = cur.next) {
//            count++;
//        }
//        System.out.println("链表中的元素的个数是：" + count + "个");
        // 6.找到链表中是否包含某个元素
        int toFind = 6;
        // 将cur放在外边，后边对cur进行判断即可知道有没有找见
        Node cur = head;
        for (;cur != null; cur = cur.next) {
            // 要是找见了，就直接跳出
            if (cur.val == toFind) {
                break;
            }
        }
        // 对cur进行判断
        if (cur == null) {
            System.out.println("没有找见");
        } else {
            System.out.println("找见了");
        }
    }
}


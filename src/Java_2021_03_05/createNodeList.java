package Java_2021_03_05;

public class createNodeList {
    public static Node createNodeList() {
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
    // 打印链表
    public static void print(Node head) {
        Node cur = head;
        for (; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }
    // 求链表的长度
    public static int getLength(Node head) {
        int count = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        Node head = createNodeList();
        print(head);
        System.out.println("链表的长度是：" + getLength(head));
    }
}

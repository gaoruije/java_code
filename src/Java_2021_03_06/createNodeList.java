package Java_2021_03_06;

public class createNodeList {
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
    public static Node createList2() {
        Node a = new Node(3);
        Node b = new Node(5);
        Node c = new Node(8);
        a.next = b;
        b.next = c;
        c.next = null;
        return a;
    }

    public static void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public static int getLength(Node head) {
        int count = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            count++;
        }
        return count;
    }
}

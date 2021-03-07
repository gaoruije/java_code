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
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // 出了循环说明，两个引用地址相同了，就是环的入口点
        Node cur1 = head;
        Node cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node createList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = c;
        return a;
    }

    public static void main(String[] args) {
        Node head = createList();
        System.out.println(returnListCycle(head));
    }
}

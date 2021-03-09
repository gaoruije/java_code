package Java_2021_03_09;

class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}

// 链表实现栈，头插表示入栈，头删表示出栈，取栈顶元素。链表头插，头删还是为了提高效率
public class MyStackForLinkedList {
    // 先搞一个链表
    private Node head = null;
    // 1.入栈,头插,不需要返回要插入的值
    public void push(int val) {
        // 将要插入的元素放在链表里边
        Node newNode = new Node(val);
        // 特殊情况的处理，空链表
        if (head == null) {// 链表本来是空的
            head = newNode;
            return;
        }
        // 处理一般情况
        newNode.next = head;
        head = head.next;
    }

    // 2.出栈，就是头删，出栈要返回一个值
    public Integer pop() {
        // 特殊情况处理，链表是空
        if (head == null) {
            return null;
        }
        // 链表之中只有一个元素，删除就没有元素了
        if (head.next == null) {
            int ret = head.val;
            head = null;
            return ret;
        }
        // 一般情况的处理
        int ret = head.val;
        head = head.next;
        return ret;
    }

    // 3.取栈顶元素
    public Integer peek() {
        // 特殊情况:要是链表是空的，没得取，返回null
        if (head == null) {
            return null;
        }
        return head.val;
    }
}

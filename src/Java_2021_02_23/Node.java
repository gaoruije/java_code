package Java_2021_02_23;

public class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }

    // 为了方便打印链表，进行方法重写
    @Override
    public String toString() {
        return "[" + val + "]";
    }
}

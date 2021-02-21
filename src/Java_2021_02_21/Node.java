package Java_2021_02_21;

// 创建一个Node的类
public class Node {
    // 设置属性
    public int val;// 表示链表内部的数据部分
    public Node next;// 用来表示链表中存的下一个元素的地址

    // 对Node进行构造方法，想进行的是插入的元素，所以对int val进行构造方法
    public Node(int val) {
        this.val = val;
    }
    // 为了后边的打印操作，要进行ToString方法重写
    // 这里只需要对val进行重写即可
    @Override
    public String toString() {
        return "[" + val + "]";
    }
}

package Java_2021_03_09;

public class MyStackForArrayList {
    // 用顺序表来实现栈
    // 栈的特点：后进先出，所以在顺序表中入栈用尾插，出栈用尾删，取栈顶元素用[]操作
    // 创建数组用来表示顺序表,栈的容量是100，要是不够后边可以进行扩容
    private int[] data = new int[100];
    // 记录顺序表的当前值
    private int size = 0;

    // 一，栈的实现:顺序表实现
    // 1.入栈，就是顺序表中国的尾插，头插也能实现，但是要进行搬运，效率太低
    public void push(int val) {
        // 特殊情况的考虑
        if (size >= data.length) {
            return;
        }
        // 一般情况的处理
        data[size] = val;
        size++;// 入栈要让size++
    }
    // 2.出栈，是有返回值的，用Integer来接收，它可以返回null。
    public Integer pop() {
        // 特殊情况
        if (size == 0) {
            return null;
        }
        // 一般情况
        int ret = data[size-1];// 保存那个出栈的元素，后边进行返回
        size--;// 出栈要让size--
        return ret;
    }
    // 3.取栈顶元素
    public Integer peek() {
        // 特殊情况
        if (size == 0) {
            return null;
        }
        return data[size - 1];
    }
}

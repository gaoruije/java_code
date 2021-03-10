package Java_2021_03_09;

public class MyQueueForArrayList {
    // 用顺序表来实现队列
    // 基本思路：让head = 0，tail = 0;队列的长度是[head，tail),包含head不包含tail。
    // 入队：tail++,入完判断tail的值，要是 == data.length,让tail从0又开始
    // 出队列：让head++
    // 这样操作当head == tail时，有两种结果：1，是队列是空的时候    2，是队列是满的时候
    // 所以用size来记录一下顺序表的具体的大小，根据size来判断队列是否为满。
    // 创建数组
    public int[] data = new int[100];
    public int head = 0;
    private int tail = 0;
    // 这个用来判断队列到底是空的还是满的
    private int size = 0;

    // 1.入队操作，tail++，然后判断size的值
    public boolean offer(int val) {
        // 特殊情况的处理,先判断size的值的大小，每一次都是以size来判断队列是否是空的
        if (size == data.length) {// 队列已经满了
            return false;
        }
        // 一般情况的处理
        data[tail] = val;
        // 完成插入之后，判断一下tail的值的
        if (tail == data.length) {// 要是让tail从0开始
            tail = 0;
        }
        // 否则更新size的值
        size++;
        return true;
    }

    // 2.出队列，核心操作，头删，head--
    public Integer poll() {
        // 特殊情况的处理
        // 队列为空，没得取
        if (size == 0) {
            return null;
        }
        // 一般情况的处理
        int ret = data[head];
        head++;
        // 每一次要判断head的值是否到达了末尾
        // 要是到达了末尾，让head也是0
        if (head == data.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    // 3.取队首元素
    public Integer peek() {
        // 特殊情况的处理
        if (size == 0) {// 为空，没得取
            return null;
        }
        return data[head];
    }
}

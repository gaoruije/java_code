package Java_2021_03_11;

import java.util.LinkedList;
import java.util.Queue;

public class useQueueRealizeStack {
    // 题目要求：只允许用两个队列来实现一个栈
    // 基本思想：先弄上两个队列A和B，队列A用来实现栈的入栈操作，出现要插入的元素的时候，就给A中进行插入
    // 入队列之后在将A中的所有的元素进行出队列，直到剩下了最后一个，在处理最后一个的时候不要让它出队列，
    // 直接不要那个元素了就行了，这样就将一个最后一个元素进行出栈了，先进后出
    // 再交换两个队列的名字，始终保持A是进行入栈的那个队列，保持B是辅助进行出栈的那个队列
    // 1.还是先准备两个队列，在准备队列的时候不能直接进行new实例要new一个LinkedList，不能直接new一个Queue
    Queue<Integer> A = new LinkedList<>();
    Queue<Integer> B = new LinkedList<>();
    /** Initialize your data structure here. */
    public useQueueRealizeStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        // 1.入栈操作直接给A里边进行插入即可
        A.offer(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 2.进行出栈操作
        // 核心操作就是将A中的元素给B里边进行倒腾
        // 特殊情况,要是A和B都是空的话，就直接返回不能入栈，因为上边给的是一个int 类，所以我们返回一个0
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        // 正常情况的处理
        // 要是A里边的元素的数量大于1个就进行给B里边插入,注意求队列里边的元素个数的时候用的是.length操作
        while (A.size() > 1) {
            // 先把A中的元素取出来就是出队列用的是.poll操作
            int ret = A.poll();
            // 再将刚取出的元素放在B的里边,就是给B里边进行入队列，.offer操作
            B.offer(ret);
        }
        // 走完了上边，就说明A中只有一个元素了，就是那个队列的最后一个元素
        // 就把这个元素作为栈的结果即可
        int temp = A.poll();// 此时A里边就是空的了，B里边就是有元素的
        // 每一次进行出栈操作的时候，要交换A和B的位置,这样就保证了下次入栈还是往A中（空的那个）进行插入的
        swapAB();
        return temp;
    }
    private void swapAB() {
        // 交换的是两个队列，所以要用的就是队列
        Queue<Integer> temp = A;
        A = B;
        B = temp;
    }

    /** Get the top element. */
    public int top() {
        // 3.取栈顶元素，操作与出栈相似。
        // 出栈的时候，是将栈顶元素直接不要了，而这个取栈顶元素是将A中最后一个元素要塞回B中去。
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        // 正常情况的处理
        // 要是A里边的元素的数量大于1个就进行给B里边插入,注意求队列里边的元素个数的时候用的是.length操作
        while (A.size() > 1) {
            // 先把A中的元素取出来就是出队列用的是.poll操作
            int ret = A.poll();
            // 再将刚取出的元素放在B的里边,就是给B里边进行入队列，.offer操作
            B.offer(ret);
        }
        // 走完了上边，就说明A中只有一个元素了，就是那个队列的最后一个元素
        // 就把这个元素作为栈的结果即可
        int temp = A.poll();
        // 这里的取栈顶元素是不能将最后一个元素删除的
        B.offer(temp);
        // 此时A里边就是空的了，B里边就是有元素的
        // 每一次进行出栈操作的时候，要交换A和B的位置,这样就保证了下次入栈还是往A中（空的那个）进行插入的
        swapAB();
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        // 要是两个队列都是空的，就说明这个栈是空的
        return A.isEmpty() && B.isEmpty();
    }
}

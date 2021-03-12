package Java_2021_03_11;

import java.util.Stack;

public class useStackRealizeQueue {
    // 题目要求：用两个栈来实现一个队列
    // 基本思想：创建两个栈，A和B，前者用来表示入队列，后者用来辅助出队列
    // 1.入队列：就直接将新的元素往A中进行插入，
    // 2.出队列：先将A中的除过最后一个元素（也就是栈底元素）剩下，然后将所有的元素出栈放在B里边
    // 要是继续想进行入队操作，就将B质中的元素全部出栈到A中，重复上边的操作即可
    // 3.取队首元素：和入队列相似，先将A中的元素倒腾到B中去，这样顺序就反了，然后就直接取栈顶元素即可
    // 这样就出队列了。
    // 创建两个新的栈
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();
    /** Initialize your data structure here. */
    public useStackRealizeQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        // 入队列的时候要将B中的所有的元素都倒腾到A中去，再给A中插入新的元素
        // 要是B中是有元素的，就要先倒腾到A中去，在给A中进行插入
        while (!B.isEmpty()) {
            // 用一个临时变量来存B中的值
            int tmp = B.pop();
            A.push(tmp);
        }
        // 现在就是将元素放在A中了，进行入队列操作
        A.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 出队列操作：要是A和B中都是空的，没得出
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        // 这里就能保证A和B中的元素都不是空的了，将A中的元素给B里边进行倒腾，直到剩下最后一个元素，直接出栈
        // 也就是出队列,要直到剩下最后一个元素
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
         return B.pop();
    }

    /** Get the front element. */
    public int peek() {
        // 3.取队首元素
        // 取队首元素，逻辑与上边相似，只是把最后一个元素放在B中去
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        // 这里就能保证A和B中的元素都不是空的了，将A中的元素给B里边进行倒腾，直到剩下最后一个元素，直接出栈
        // 也就是出队列,要直到剩下最后一个元素
        while (!A.isEmpty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 删除B中的元素
        return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        // 判断队列是否是空的
        return A.isEmpty() && B.isEmpty();
    }
}

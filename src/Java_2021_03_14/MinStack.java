package Java_2021_03_14;

import java.util.Stack;

public class MinStack {
    // 设计一个能实现push，pop，top，并能以时间复杂度是O（1）来访问该栈的最小元素
    // 基本思路：弄上两个栈，A用来进行元素的插入，删除，等基本操作。B用来保存A中的最小元素
    Stack<Integer> A = new Stack<>();// 用来进行元素的一般的操作
    Stack<Integer> B = new Stack<>();// 用来存放A中的最小值
    public MinStack() {

    }
    // 1.入栈操作，切记，A和B的操作都是同时进行的
    public void push(int x) {
        // 插入操作，要保证给A和B中都进行插入，设定B的目的就是放A中的最小元素
        // 将元素x插入到A中去
        A.push(x);
        // 接下来，要将A中的最小元素给B中进行插入
        // a.特殊情况的处理
        if (B.isEmpty()) {// 要是B中本来就没有元素，不用比较，直接给B中插入
            B.push(x);
            return; // 插入后要进行返回
        }
        // b.一般情况的处理，B栈中的元素不是空的，要进行比较
        // 就是将B的栈顶元素和要插入的元素比较
        int min = B.peek();// 将B的栈顶元素拿了出来
        if (min < x) {
            B.push(min);
        } else {
            B.push(x);
        }
    }

    // 2.出栈操作，还是A和B要同时进行
    public void pop() {
        // 特殊情况的处理
        if (A.isEmpty()) {
            return;
        }
        // 否则给A和B进行出栈操作
        A.pop();
        B.pop();
    }

    // 3.取栈顶元素
    public int top() {
        // 特殊情况的处理
        if (A.isEmpty()) {// 没得出
            return 0;
        }
        // 一般情况的处理
        return A.peek();
    }

    // 4.取栈里边的最小元素
    public int getMin() {
        // 特殊情况的处理
        if (B.isEmpty()) {
            return 0;
        }
        // 一般情况的处理,返回B的栈顶元素
        return B.peek();
    }
}

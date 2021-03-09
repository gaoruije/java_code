package Java_2021_03_09;

// 基于链表来实现队列
// 因为队列是先进先出的，所以用尾插表示入队列。头删表示出队列，.操作表示取队列元素

public class MyQueueForLinkedList {
    // 弄一个Node内部类,要带上static，为了和外部的实例无关
     static class  Node {
         int val;
         Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    // 先创建一个链表，并记录其头节点和尾节点，方便后边的进行尾插
     Node newHead = null;
     Node newTail = null;

    // 1.入队列,就是尾插，为了和Java库中的队列保持一致，用boolean返回值
    public boolean offer(int val) {
        // 将要插入的值放在Node 节点里面
        Node newNode = new Node(val);
        // 情况特殊的处理
        if (newHead == null) {
            // 头节点和尾节点都是要插入的值
            newHead = newNode;
            newTail = newNode;
            return true;
        }
        // 一般情况的处理
        newTail.next = newNode;
        newTail = newTail.next;
        return true;
    }

    // 2.出队列，就是头删，注意头删也是要返回那个要删除的值
    public Integer poll() {
        // 特殊情况的处理,链表为空没得删
        if (newHead == null) {
            return null;
        }
        // 链表只要一个元素
        if (newHead.next == null) {
            int ret = newHead.val;
            // 新头节点就没有了，就是null
            newHead = null;
            return ret;
        }
        // 处理一般情况的处理
        int ret = newHead.val;
        newHead = newHead.next;
        return ret;
    }
    // 3.取队列首元素
   public Integer peek() {
        // 特殊情况的处理
       // 链表为空，没得取
       if (newHead == null) {
           return null;
       }
       // 一般情况的处理
       return newHead.val;
   }
}

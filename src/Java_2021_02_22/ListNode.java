package Java_2021_02_22;

public class ListNode {
    // 创建一个链表
    public  static Node createList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        return a;
    }

    // 创建一个带傀儡节点的链表，傀儡节点只是为了为了方便后边的插入，实际不占链表的长度
    // 带傀儡节点的链表将头插和任意位置插入结合在了一块了
    public static Node createListWithDummy() {
        Node dummy = new Node(0);
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        dummy.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        return dummy;
    }

    // 4.给链表进行尾插操作
    public static Node insertTail(Node head,int val) {
        // 先进行判断，链表是否是一个空链表
        Node newNode = new Node(val);
        if (head == null) {
            // 空链表也是能插入的
            return newNode;
        }
        // 再进行找链表的最后一个元素
        Node prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }
        // 这个循环走完后，就到了最后一个元素
        // 进行插入操作
        newNode.next = prev;
        prev.next = newNode;
        return head;
    }

    // 5.链表中的删除元素的操作，按照值来进行删除
    public static void remove(Node head,int value) {// 方法中既有链表，又有要删除的值
        // 首先找到要删除元素的前一个元素
        Node prev = head;
        while (prev != null && prev.next != null && prev.next.val != value) {
            prev = prev.next;
        }

        // 出了循环prev指向的就是要删除节点的前一个节点
        // 进行判断，看是否找到了要删除的元素
        if (prev == null || prev.next == null) {// 说明没有找见
            return;
        }
        // 下边就说明找见了，进行删除
        Node toDelete = prev.next;// 相当于就是要删除的节点
        prev.next = toDelete.next;// 直接跳过了要删除的节点了，删除成功了
    }

    // 6.链表中的删除元素操作，按照位置来进行删除,要进行遍历操作，时间复杂度是O(N)
    public static void remove(Node head,Node toDelete) {// node就是节点存的就是那个位置
        Node prev = head;
        while (prev != null && prev.next != toDelete) {
            prev = prev.next;
        }
        // 找完进行判断一下
        // 要是prev为null，结束循环的说明没有找见
        if (prev == null) {
            return;
        }
        // 下边就是因为找到了toDelete的值而结束循环的，进行真正的删除
        prev.next = toDelete.next;
    }

    // 按照位置进行删除元素，时间复杂度为O(1)，缺点是不能删除最后一个节点
    public static void remove2(Node head,Node toDelete) {
        Node nextNode = toDelete.next;
        // 将nextNode的值赋值给toDelete
        nextNode.val = toDelete.val;
        // 直接改变指向，删除成功
        toDelete.next = nextNode.next;
    }


    public static void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }

    }
    public static void main(String[] args) {
        //用head来接收头节点，也就是获取了整个链表
        // Node head = createList();

        // 1.给链表的中间位置插入元素
        // 给1和2之间插入元素
//        Node one = head;
//        Node newNode = new Node(100);
//        newNode.next = one.next;
//        one.next = newNode;
//        for (Node cur = head; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }
        // 给4和5之间插入元素
//        int n = 4;
//        // a)首先找到要插入元素的前一个节点
//        Node cur = head;
//        for (int i =  1; i < n ; i++) {
//            cur = cur.next;
//        }
//        // 这里就找到要插入的位置了
//        Node cur1 = cur;
//        // 进行插入
//        Node newNode = new Node(6);
//        // 先将newNode的指向下一个元素节点
//        newNode.next = cur1.next;
//        // 再将cur1指向newNode
//        cur1.next = newNode;
//        for (Node cur2 = head; cur2 != null; cur2 = cur2.next) {
//            System.out.println(cur2.val);
//        }

        // 2.进行头插元素
        // 因为头插前边没有元素了（这个相对来说就简单了不用找前一个节点）
        // 所以直接让newNode 指向head，head 在指向newNode即可
//        Node newNode = new Node(100);
//        newNode.next = head;
//        head = newNode;
//        for (Node cur = head; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }
//

        // 3.带傀儡节点的插入，将头插和任意位置插入结合在了一块
        // 先创建一个带傀儡节点的链表
        //Node head = createListWithDummy();
        // a.给中间位置进行插入，插入位置1和2之间
        // 要插入的元素的值
//        Node newNode = new Node(10);
//        // 还是先找到要插入位置的前一个位置
//        Node prev = head.next;
//        newNode.next = prev.next;
//        prev.next = newNode;
//        // b.进行头插
////        Node prev1 = head;
////        newNode.next = prev1.next;
////        prev1.next = newNode;
//        for (Node cur = head; cur != null; cur = cur.next) {
//            System.out.println(cur.val);
//        }
//        Node head = createList();
//       // Node head = null;
//        head = insertTail(head,100);
        Node head = createList();
        //***删除3这个节点,有点小问题，差一个下标
        Node toDelete = head.next.next.next;
        remove2(head,toDelete);
        print(head);


    }
}

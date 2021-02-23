package Java_2021_02_23;

import static sun.misc.Version.print;

public class Main {
    public static Node createList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return a;
    }

    // 1.将一个数组转化为链表
    // 法a)创建的是一个不带傀儡节点的链表，后边插入要防止链表为空，要进行分支判断
    public static Node arrayToLinkedList(int[] arr) {
        // 思路就是遍历数组中的每一个元素，给链表进行尾插即可
        // 又因为每次尾插的时候都要知道链表的尾节点，所以用一个引用来记下，就会方便很多
        // head 就是头节点的引用，初始情况下，链表是空的
        Node head = null;
        // 初始情况下，链表的尾节点也是空的
        Node tail = null;
        // 进行for循环比那里数组
        for (int x: arr) {
            Node node = new Node(x);
            // 再将node进行尾插
            if (head == null) {// 要是链表本来就是空的，直接填入
                head = node;
                tail = node;
            } else {// 说明链表不是空的，直接进行尾插
                // 将 node 的值给tail.next
                tail.next = node;
                // 不要忘了每次插入完成要更新tail的引用的指向
                tail = tail.next;
            }
        }
        // 插入完成后，返回一个链表，就是返回head即可，返回一个链表的头节点就是返回了整个链表
        return head;
    }

    // 法b)创建一个带傀儡节点的链表，就可以防止head是空的，就将分支放在一个里边了
    public static Node arrayToLinkedList2(int[] arr) {
        // 先创建一个傀儡节点,随便给一个值，没有实际意义，就是为了方便统一代码
        Node head = new Node(0);
        // 因为此时的head必定不是空，所以可以直接进行遍历数组的元素进行插入
        // 创建一个尾节点的引用
        Node tail = head;
        for (int x: arr) {
            Node node = new Node(x);
            //进行真正的插入
            tail.next = node;
            tail = tail.next;
        }
        // 后边注意，人家要的是返回原来的数组，所以不能从head返回
        // 要从head的next进行返回
        return head.next;
    }

    // 2.创建一个打印链表的方法，方便后边进行测试
    public static void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        //Node head = arrayToLinkedList(arr);
        Node head = arrayToLinkedList2(arr);
        print(head);
    }

}

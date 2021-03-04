package Java_2021_03_04;

public class listSolutionPractice {
    // 创建链表
    public static Node createList() {
        Node a = new Node(9);
        Node b = new Node(5);
        Node c = new Node(2);
        Node d = new Node(7);
        Node e = new Node(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        return a;
    }

    // 计算链表的长度
    public static int getLength(Node head) {
        int count = 0;
        for (Node cur = head; cur != null; cur = cur.next) {
            count++;
        }
        return count;
    }

    // 依次打印链表中的所有的元素
    public static void print(Node head) {
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }
    }

    // 1.链表逆置
    // 基本思路：给定三个引用到时改变引用的指向即可
    public static Node reverseList(Node head) {
        // 特殊链表的处理
        if (head == null) {
            return null;
        }
        // 要是链表只有一个元素
        if (head.next == null) {
            return head;
        }
        // 一般情况的处理，创建三个引用
        Node prevNode = null;
        Node curNode = head;
        // 因为后边要返回那个新的头节点，来个引用来表示一下，后边直接赋值
        Node newHead = null;
        // 进行遍历操作,只要curNode不是空就继续改变指向
        while (curNode != null) {
            // 因为那个nextNode是随每一次的循环而改变的，所以讲nextNode引用的创建放在里边
            Node nextNode = curNode.next;
            // 进行判断,改变引用的指向
            if (curNode == null) {
                newHead = curNode;
            }
            // 要是不是null，就改变指向
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }
        // 最后在返回newHead即可
        return newHead;
    }

    // 2.返回链表中间节点,要是只有一个中间节点返回中间节点，要是两个中间节点，返回第二个中间节点
    // 思路：计算连表的长度，然后长度/2，让应用走长度/2步数即可
    public static Node returnMidNode(Node head) {
        // 要是链表为空
        if (head == null) {
            return null;
        }
        // 解决一般的情况
        // 需要一个计算连表长度的方法
        int result = getLength(head);
        // 得到引用走的步数
        int steps = result / 2;
        // 控制引用向后走
        Node cur = head;
        for (int i = 0; i < steps; i++) {
            // 这里没有必要判定cur解应用的时候会不会触发空指针异常
            // 因为只有cur到链表的外边的时候才会触发，但是cur走的步数一定是小于链表result的长度
            cur = cur.next;
        }
        return cur;
    }

    // 3.删除链表中的所有值为val的所有节点
    public static Node deleteElements (Node head,int val) {
        // 先进行中间元素的判定，判定完成之后在进行头部的判定
        Node prev = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                // 找见了就进行删除
                prev.next = cur.next;
                // 对cur进行更新
                cur = cur.next;
            } else {// 就是没有和要删除元素相等，改变指向
                prev = prev.next;
                cur = cur.next;
            }
        }
        // 走完上边说明已经处理完了所有中间的节点，进行头节点的处理
        if (head.val == val) {
            head = head.next;
        }
        // 最后返回链表的头节点
        return head;
    }

    // 4.给定一个链表，返回链表中的倒数第K个节点，可知K的个数是[1,length]
    // 思路：直接求出链表总的节点个数（length），然后倒数第k个节点就是正数第（length-k）个节点
    public static Node findKthToTail(Node head,int k) {
        // 还是先进行合法性判断
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        // 获取链表的长度
        int length = getLength(head);
        if (k > length) {// k的范围不正常
            return null;
        }
        // 进行一般的查找
        Node cur = head;
        // 用一个步数来表示要向后走多少步
        int steps = length - k;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        // 最后得到的就是倒数第k个节点了
        return cur;
    }

    // 5.将两个有序的链表拼接成一个长的链表，并要求拼接后的长的链表也是有序的
    // 基本思路：创建一个新的链表用来存放排好顺序的链表，给定两个引用分别指向两个链表，
    // 然后依次比较两根引用的值的大小，将较小的值放在新的链表中去（尾插），更新引用的指向
    // 直到一个链表出现空的时候，就不用再进行了，直接将剩余的链表尾插即可
    public static Node mergerTwoLists(Node l1,Node l2) {
        // 特殊情况的处理
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        // 一般情况的处理，进行合并，创建两个引用
        Node cur1 = l1;
        Node cur2 = l2;
        // 创建一个新的链表来进行数据的存储
        Node newHead = null;
        // 因为后面要频繁的进行尾插操作，可以用一个引用来记录尾部
        Node newTail = null;// 初始情况下链表是空的，所以尾部也是指向空
        // 循环遍历链表，进行尾插,要是有任意一个引用指向空的时候就不用再进行循环
        while (cur1 != null && cur2 != null) {
            // 尾插的时候有两种情况，一种是给空链表进行插入，一种是给非空链表进行尾插
            if (cur1.val < cur2.val) {// 将cur1的值给新的链表中插入
                // 判断链表是否是空
                if (newTail == null) {
                    newHead = cur1;
                    newTail = cur1;
                } else {// 针对非空链表的插入
                    newTail.next = cur1;
                    // 每一次都要修改newTail的指向
                    newTail = newTail.next;
                }
            } else {// 将cur2的值给新的链表中间插入，包含了两个都是空的情况
                if (newTail == null) {
                    newTail = cur2;
                    newHead = cur2;
                } else {
                    newTail.next = cur2;
                    newTail = newTail.next;
                }
            }
        }
        return newHead;
    }


    public static void main(String[] args) {
        Node head = createList();
//        returnMidNode(head);
//        System.out.println("中间节点的值是" + returnMidNode(head));
//        reverseList(head);
//        print(head);
        System.out.println( "返回的节点是：" + findKthToTail(head,2));
    }
}

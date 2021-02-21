package Java_2021_02_21;

public class Main {

    // 手动创建一个链表
    // 通过头节点来代指整个链表，最后返回头节点即可
    public static  Node createNode() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        // 让节点指向下一个节点
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        // 最后一个节点要指向空
        e.next = null;
        // 最后返回头节点，就是把a的地址返回到方法外边去了
        return a;
    }

    public static void main(String[] args) {
        // 1.通过head来接收一下这个头节点，获得了头节点也就是获得了整个链表了。
        Node head = createNode();

        // 2.遍历整个链表,并打印链表中的所有的元素，从头节点开始依次next在进行.val来输出值
        for (Node cur = head; cur != null; cur = cur.next) {
            System.out.println(cur.val);
        }

        // 3.通过遍历链表获取链表的最后一个节点
        // 就是遍历链表，只要找到指向为null的那个节点，这个节点就是最后一个节点
        Node cur = head;
        // 这里的 .操作 是解引用，所以要防止空指异常，所以提前加个条件（cur != null）。
        while ( cur != null && cur.next != null) {
            cur = cur.next;
        }
        // 走完循环则cur一定指向null，直接打印节点里边的值
        System.out.println(cur.val);

        // 4.通过遍历找到链表的倒数第二个节点
        Node cur1 = head;
        // 牵扯到解引用还是要判断.next操作要正常
        while (cur1 != null && cur1.next != null && cur1.next.next != null) {
            cur1 = cur1.next;
        }
        // 走完循环则说明cur1.next.next 是空，此时的位置就是倒数第二个节点了
        System.out.println(cur1.val);

        // 5.通过遍历链表找到倒数第n个节点
        int n = 2;//想让取第二个节点
        Node cur2 = head;
        for (int i = 1; i < n; i++) {
            cur2 = cur2.next;
        }
        // 循环完成后就说明到了第N个节点了，进行打印输出
        System.out.println(cur2.val);


        // 6.通过遍历计算链表中的元素的个数
        // 准备count进行计数
        int count = 0;
        for (Node cur3 = head; cur3 != null; cur3 = cur3.next) {
            count++;
        }
        //最后输出count
        System.out.println("链表的长度是： " + count);

        // 7.通过遍历找到链表中是否包含某个元素
        int toFind = 4;
        Node cur4 = head;
        for (; cur4 != null; cur4 = cur4.next) {
            if (cur4.val == toFind) {//就返回不用找了，直接跳出循环
                break;
            }
        }
        // 找完后对cur进行判断
        if (cur4 != null) {
            System.out.println("找到了");
        } else {
            System.out.println("没找见");
        }
    }
}

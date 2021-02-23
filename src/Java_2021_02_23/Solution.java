package Java_2021_02_23;

// 先创建一个链表的类
class ListNode {
    int val = 0;
    ListNode next = null;
    // 不带参数的构造方法

    public ListNode() {
    }

    // 带一个参数的构造方法
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = null;
    }
}
public class Solution {
    // 1.题目要求：删除链表中等于给定值 val 的所有节点。
    // 基本思路就是依次遍历链表的所有的元素，找到要删除元素的前一个节点，改变其指向即可
    // 还有就是应该先删除中间节点，要不然，头删只能进行一次，要是第二个元素也是待删除元素的话就不能删除了
    // 只要先进行完中间节点的删除，最后最多剩余的那个头节点是待删除元素，这样就能全部删除了
    public ListNode removeElements(ListNode head, int val) {
        // a)先判断链表是否为空
        if (head == null) {
            return null;
        }
        // b)进行中间位置的删除
        // 先创建一个引用是待删除节点的前一个节点记为prev
        ListNode prev = head;
        // 再创建另外一个引用是待删除节点
        ListNode cur = prev.next;
        // 进行遍历操作
        while (cur != null) {
            if (cur.val == val) {// 就找到了值为val的值，进行删除
                prev.next = cur.next;
                // 同时要修改cur的指向
                cur = prev.next;
            } else {// 说明没有找到要删除的元素,更新prev和cur的指向即可
                prev = prev.next;
                cur = cur.next;
            }
        }
        // c)再判断链表要删除的元素是否是头节点的元素,要是是待删除元素就直接删除即可
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    // 2.链表逆置
    // 基本思想，就是创建三个引用，让第一个先指向空，然后修个每个引用的指向即可
    public ListNode reverseList(ListNode head) {
        // a)链表本身就是空
        if (head == null) {
            return null;
        }
        // b)链表中只有一个元素，直接返回头节点即可
        if (head.next == null) {
            return head;
        }
        // c)进行一般位置的逆置
        // 先创建一个新的头节点，让其指向空，因为后边在进行逆置完成后要将最后的呢个节点赋值给这个新的头节点
        ListNode newHead = null;
        ListNode prevNode = null;
        ListNode curNode = head;
        // 进行循环操作来翻转
        while (curNode != null) {
            // 进入循环的时候首先要设置好 nextNode 的位置,每一次都要进行更新，所以直接放在里边了
            ListNode nextNode = curNode.next;
            if (nextNode == null) {
                // curNode就指向了最后一个节点了，也就是说curNode应该是新链表的头节点了
                newHead = curNode;
            }
            // 进行翻转
            curNode.next = prevNode;
            // 更新引用的位置
            prevNode = curNode;
            curNode = nextNode;
        }
        return newHead;
    }

}

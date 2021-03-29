package java_2021_0329;

public class LinkedListNodePractice {
    // 7.删除链表中的所有的重复的节点
    public ListNode deleteDuplication(ListNode pHead) {
        // 基本思想：创建一个新的带傀儡节点的额链表用来存储没有重复的节点
        // 特殊情况处理
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        // 一般情况处理
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        // 从前给后遍历链表
        ListNode cur = pHead;
        while (cur != null) {
            if (cur != null && cur.next != null &&
                    cur.val == cur.next.val){
                //要是相邻的元素是一样的，就直接跳过
                // 相邻的元素不止是一个，所以里边要再来一个循环
                while (cur != null && cur.next != null &&
                        cur.val == cur.next.val){
                    cur = cur.next;
                }
            } else {// 说明相邻元素是不相等的，将元素插入，并改变cur的指向
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
            }
            // 每进行一次循环要更新条件
            cur = cur.next;
        }
        // 最后进行返回节点即可
        return newHead.next;
    }

    // 8.判断链表是否是回文结构
    public boolean chkPalindrome(ListNode A) {
        // write code here
        // 特殊情况处理
        if (A == null) {
            return true;
        }
        if (A.next == null) {
            return true;
        }
        // 一般情况处理
        // 拷贝链表
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        for (ListNode cur = A; cur != null; cur = cur.next) {
            newTail.next = new ListNode(cur.val);
            newTail = newTail.next;
        }
        ListNode B = newHead.next;
        // 逆置拷贝后的链表
        ListNode prev = null;
        ListNode cur = B;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                B = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 3.比较两个链表看是否一样
        ListNode cur1 = A;
        ListNode cur2 = B;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 要是走完前边的额循环说明两个链表是一样的
        return true;
    }

    // 9.给定两个链表，返回他们两个相交的节点，要是不相交，则返回null
    public int getLength(ListNode head) {
        int count = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            count ++;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 先让两个链表的起始位置相同
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if (lengthA > lengthB) {
            // 让headA先走多的步数
            int steps = lengthA - lengthB;
            for (int i = 0; i < steps; i++) {
                headA = headA.next;
            }
        } else {
            int steps = lengthB - lengthA;
            for (int i = 0; i < steps; i++) {
                headB = headB.next;
            }
        }
        // 经过上边的处理，两个链表就齐头了，下边让连个链表遍历
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 走完循环还是没有发现相等的就说明没有相交的节点
        return null;
    }

    // 10.给定一个链表判断是否带环
    public boolean hasCycle(ListNode head) {
        // 基本思想：设定一个快慢指针，让快的一次走两步，慢的一次走一步，要是最后两个相交的话，说明次链表是带环的
        // 特殊情况处理
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        // 一般情况的处理
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        // 循环结束后要是还没有相等的，则链表没有带环
        return false;
    }

    // 11.返回带环链表的入口位置
    public ListNode detectCycle(ListNode head) {
        // 特殊情况处理
        if (head == null) {
            return null;
        }
        // 判断链表是否是有环的
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 上边的循环结束后，判断一下，结束循环的原因
        if (fast == null || fast.next == null) {// 链表是没有环的
            return null;
        }
        // 这里的链表一定是带环的
        ListNode cur1 = head;
        ListNode cur2 = fast;
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        // 出来之后的链表一定就是走到距离相等的情况了
        return cur1;
    }
}

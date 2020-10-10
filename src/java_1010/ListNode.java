package java_1010;

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  //删除链表中的节点，这个节点不是尾节点
    class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;//因为不是尾删，所以node一定存在next，所以先把node的值换成node.next的值
            node.next = node.next.next;//这里直接改变node的指向即可。
        }
    }


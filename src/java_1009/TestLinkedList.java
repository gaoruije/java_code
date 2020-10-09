package java_1009;

public class TestLinkedList {
    //1，验证链表头插的代码
   private static void testAddFirst(){
       LinkedList linkedList = new LinkedList();
       linkedList.addFirst(1);
       linkedList.addFirst(2);
       linkedList.addFirst(3);
       linkedList.addFirst(4);
       linkedList.disPlay();
   }
   //2,验证链表尾插的代码
   private static void testAddLast(){
       LinkedList linkedlist = new LinkedList();
       linkedlist.addLast(1);
       linkedlist.addLast(2);
       linkedlist.addLast(3);
       linkedlist.addLast(4);
       linkedlist.addLast(5);
       linkedlist.disPlay();
   }
   //3,验证给链表中间位置插入元素
    private static void testAddIndex(){
       LinkedList linkedlist = new LinkedList();
       linkedlist.addIndex(0,1);
       linkedlist.addIndex(1,2);
       linkedlist.addIndex(1,3);
       linkedlist.addIndex(1,4);
       linkedlist.disPlay();
    }
    //4,验证找链表中是否存在某个元素
    private static void testContains(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        System.out.println(linkedList.contains(6));
    }
    //5,验证删除链表中的指定值得方法
    private static void testToRemove(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.Remove(2);
        linkedList.disPlay();
    }

    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddIndex();
        testContains();
        testToRemove();
    }
}

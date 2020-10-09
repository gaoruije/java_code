package java_1009;

public class LinkedList {//表示一个节点,两个数据
    class Node{
        public int data;//数据
        public Node next = null;//下一个节点的位置。

        public Node(int data) {
            this.data = data;
        }
    }
        //要管理所有链表节点，只需要记录头节点的位置即可
        private Node head = null;//表示的是空链表

    //1，头插元素
        public void addFirst(int data){
            //a，先根据data值来构建一个链表节点（Node对象）
            Node node = new Node(data);
            //b,如果链表是空链表
            if(head == null){
                head = node;
                return;
            }
            //c,如果链表不是空的
            node.next = head;
            head = node;
        }
        //2，尾插元素
        public void addLast(int data){
            //a，创建有一个Node对象
            Node node = new Node(data);
            //b,如果链表为空
            if(head == null){
                head = node;
                return;
            }
            //c,如果链表不为空，需要先找到尾节点。
            Node tail = head;//给初始值设置为head，依次向下找，直到找到null截止
            while(tail.next != null){
                tail = tail.next;//更新了tail。
            }
            //当循环结束的时候就找到尾节点了,找到后就直接插入
            tail.next = node;
        }
        //3，把链表中的元素打印出来
        public void disPlay(){
            for(Node cur = head; cur != null; cur = cur.next){
                System.out.print(cur.data + " ");
            }
            System.out.println();
    }
    //4，给指定位置插入元素,成功返回true，否则返回false。
    public boolean addIndex(int index, int data){
            int size = getSize();
            //a,判定位置是否有效。
        if(index < 0 || index > size){//size 表示的值链表的长度，size还是从 0 开始的
                                      //当插入的index = size时就是尾插，符合条件。
            return false;
        }
        //b,如果index是0，这就是头插，直接调用前边的addfirst方法
        if(index == 0){
            addFirst(data);
            return true;
        }
        //c,如果index是size，则就是尾插，直接调用addlast方法
        if(index == size){
            addLast(data);
            return true;
        }
        //d,中间位置的插入，主要是要找到指定位置的前一个位置。
        //找到了index的前一个节点，也就是index-1.
        Node node = new Node(data);
        Node prev = getPos(index-1);
        //然后插入
        node.next = prev.next;
        prev.next = node;
        return true;
    }
    //辅助index插入元素的方法，给定index下标，能找到对应节点的位置，getpos方法。
    private Node getPos(int index){
            Node cur = head;
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
            return cur;
    }
    //辅助index插入元素的方法，获取链表长度的方法，getsize方法
    public int getSize(){//用int就是返回的是具体的值。
            int size = 0;
            for(Node cur = head; cur != null; cur = cur.next){
                size++;
            }
            return size;
    }
    //5,判断链表中的元素是否存在，contains方法
    public boolean contains(int toFind){
            for(Node cur = head; cur != null; cur = cur.next){
                if(cur.data == toFind){
                    return true;
                }
            }
            return false;
    }
    //6,删除指定元素来删除元素只删除一个，按值删除,就要先找出下标再进行删除。
    public void Remove(int toRemove){
            //a,要是要删除的元素是头节点
        if(head.data == toRemove){
            head = head.next;
        }
        //要是不是头节点，则应该先找到要删除元素的上一个元素的位置。
        Node prev = searchPrev(toRemove);
        //修改引用的指向。
        prev.next = prev.next.next;
    }
    //7，删除链表中的所有包含指定的元素。
    public void removeAll(int toRemove){
            //a,先删除非头节点的所有数字。
        Node prev = head;
        Node cur = head.next;
        while(cur != null){
            if(cur.data == toRemove){
                prev.next = cur.next;
            }
            prev = cur;
            cur = cur.next;
        }

    }
    public Node searchPrev(int toRemove){
            for(Node cur = head; cur != null && cur.next != null; cur = cur.next){
                if(cur.next.data == toRemove){
                    return cur;
                }
            }
            return null;
    }
}

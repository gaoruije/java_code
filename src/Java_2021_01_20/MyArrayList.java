package Java_2021_01_20;

import java.util.Arrays;

class MyArrayListIndexOutOfRangeException extends RuntimeException{
    public MyArrayListIndexOutOfRangeException(String message) {
        super(message);
    }
}
public class MyArrayList {
    // 认为List  中存的是若干个 String 对象
    // 设置属性
    private String[]  data = null;
    //设置顺序表的当前长度从 0 开始
    private int size = 0;
    // 设置顺序表的最大容量是 100
    private int capacity = 100;

    // 设置方法，增删改查
    public MyArrayList () {
        //创建一个和原来容量一样的数组，后边的解引用的时候就不会空指针异常了
        data = new String[capacity];
    }

    // 实现扩容的方法
    private void realloc() {// 用的是private,体现了封装的思想，不想让调用者知道内部的实现过程
        // 先把capacity的值变化
        capacity = 2 * capacity;
        // 载创建一个新的数组对象,它的容量已经成为原来的2倍了
        String[] newDate = new String[capacity];
        // 扩容一定是触发了size > capacity 之后才进行的，所以要将原来数组中的元素拷贝到新的数组中去。
        for (int i = 0; i < data.length; i++) {
            newDate[i] = data[i];
        }
        //将新的大数组赋值给原有的属性 date，同时GC会释放掉原来的空间,扩容完成
        data = newDate;
    }


    // 1.增添的方法
    // a)进行尾插
    public void add (String elem) {
        // 直接将元素插入即可，每次添加完size 要进行加加
        // 先要进行判定，要是size >= capacity 就需要进行扩容
        if (size >= capacity) {// 触发扩容操作，直接调用realloc方法
            realloc();
        }
        data [size] = elem;// 这里触发了解引用操作，所以上边要来一个构造放法
        size ++;
    }
    // b)给任意位置进行插入元素
    public void add (int index,String elem) {
        // 还是先进行判定是否触发了扩容操作
        // 先要对index进行判定
        if (index < 0 || index > size) {// 要是index刚好=size就相当于是尾插
            return;
        }
        if (size >= capacity) {
            realloc();
        }
        // 将元素插入到index的位置，就要先找到index的位置，将index往后的所有的元素依次向后进行搬运
        // 注意搬运是从后向前搬运这样才不会覆盖别的元素
        for (int i = size - 1; i >= index; i--) {// 注意index位置的也要向后移
            data[i + 1] = data[i];
        }
        // 交换完成后直接将elem放在index位置即可
        data[index] = elem;
        //插入完成后要进行加加
        size++;
    }

    // 为了后边的打印自己写的MyArrayList
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i <= size - 1; i++) {
            stringBuilder.append(data[i]);
            if (i < size - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    // 2.进行删除操作
    // a)按照指定位置进行删除元素，返回值是一个眼删除的元素的值
    private String remove(int index) {
        // 还是先进行判断，看看所给的下标是否符合实际
        if (index < 0 || index >= size) {
            return null;
        }
        // 因为这个的返回值是一个要删除的元素，所以提前将要删除的元素记录下来
        String result = data[index];
        // 下边进行删除,将index后边的元素依次向前进行搬运
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        // 删除完毕元素后size要进行--
        size--;
        return  result;
    }
    // b)按照所给的元素的值进行删除元素，返回值是真假，要能删除元素就返回true，否则返回false
    private boolean remove(String elem) {
        // 先要依次遍历这个顺序表，要是找到和elem相同的元素就直接删除，返回true，否则返回false
        // 这里将for循环中的i的值放在外边，为了后边看i的值是否在size范围中，进而判断是否删除成功
        int index = 0;
        for (; index < size - 1; index++) {
            // 进行比较，用.equals来进行
            if (data[index].equals(elem)) {// 要是找到了就能进入里边，直接跳出循环，不用再找了
                break;
            }
        }
        // 对i的值进行判断,没有找到元素,删除失败
        if (index >= size) {
            return false;
        }
        // 找到了，进行删除，最后删除成功
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        // size要更新
        size--;
        return true;
    }


    // 3，根据下标获取元素
    private String get(int index) {
        // 要是下标不正常
        if (index < 0 || index > size - 1) {
            // 可以直接返回一个空
            // return null;
            // 或者可以抛出一个异常
           throw new MyArrayListIndexOutOfRangeException("下标越界了 index：" + index);
        }
        return data[index];
    }


    // 4.根据下标修改元素
    private void set(int index, String elem) {
        // 还是先进行判断下标是否越界
        if (index < 0 || index > size -1) {
            throw new MyArrayListIndexOutOfRangeException("下标越界了 index：" + index);
        }
        data[index] = elem;
    }

    // 5,查找元素是否存在
    private boolean contains(String elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return true;
            }
        }
        return false;
    }

    // 6,查找元素，返回下标
    private int indexOf(String elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }


    // 7.从后向前查找元素，并返回下标
    private int lastIndex(String elem) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    // 8.清空所有的元素
    private void clear() {
        size = 0;
    }

    // 9.判断长度
    private int size() {
        return size;
    }

    // 10.判空
    private boolean isEmpty() {
        return size == 0;
    }


    // 测试清空，判空，求长度方法
    private static void testEmptySizeClear() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("c#");
        myArrayList.add("python");
        myArrayList.add("Java");
        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.size());
        myArrayList.clear();
        System.out.println(myArrayList.isEmpty());
        System.out.println(myArrayList.size());


    }
    // 测试查找的方法
    private static void testContainsAndIndex() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("c#");
        System.out.println(myArrayList.contains("c"));
        System.out.println(myArrayList.indexOf("c"));
        System.out.println(myArrayList.lastIndex("c"));
        System.out.println(myArrayList.lastIndex("hello"));
    }
    // 测试get，set方法
    public static void testGetAndSet() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("c#");
        myArrayList.add("python");
        myArrayList.get(5);
        System.out.println(myArrayList.get(2));
        myArrayList.set(2,"java");
        System.out.println(myArrayList);

    }
    // 测试添加内容的方法
    private static void testAdd() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("高瑞杰说：");
        myArrayList.add("hello");
        myArrayList.add("c");
        myArrayList.add("Java");
        // 要进行打印就要进行ToString 方法的重写
        myArrayList.add(1,"李育欢是个大狗熊，不，是个黑狗熊！！！");
        myArrayList.add(2,"说的真好");
        System.out.println(myArrayList);
    }
    // 测试删除的方法
    private static void testRemove() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("c");
        myArrayList.add("c++");
        myArrayList.add("c#");
        myArrayList.add("python");
        myArrayList.add("Java");
        System.out.println("原来的元素是： " + myArrayList);
        myArrayList.remove(2);
        System.out.println("删除后的元素是：" + myArrayList);
        myArrayList.remove("Java");
        System.out.println("删除后的元素是：" + myArrayList);
        myArrayList.remove("hello");
        System.out.println("删除后的元素是：" + myArrayList);
    }

    // 在main方法中进行测试一下
    public static void main(String[] args) {
        testAdd();
        //testRemove();
        //testGetAndSet();
        //testContainsAndIndex();
        //testEmptySizeClear();
    }
}

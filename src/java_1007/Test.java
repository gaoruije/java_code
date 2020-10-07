package java_1007;

import java.util.Arrays;

import static java_1007.ArrayList.binarySearch;
import static java_1007.ArrayList.bubbleSort;

public class Test {
        private static void testAdd(){
        SeqList seqList = new SeqList();
        seqList.display();
        //底下就是单元测试，将每一个要测试的方法进行模块化，就是单元测试。
        //1，测试的是add方法。
        //a,测试尾插
        //b,测试普通位置插入
        //c,测试扩容
        //d,测试普通插入
        seqList.add(0,11);
        seqList.add(0,12);
        seqList.add(0,13);
        seqList.add(0,14);
        seqList.display();
    }
    //测试contains的方法。
    private static void testContains(){
            SeqList seqList = new SeqList();
        seqList.add(0,11);
        seqList.add(0,12);
        seqList.add(0,13);
        seqList.add(0,14);
        System.out.println(seqList.contains(2));
        System.out.println(seqList.contains(12));

    }
    private static void testSearch(){
            SeqList seqList = new SeqList();
            seqList.add(0,100);
            seqList.add(0,200);
            seqList.add(0,300);
            seqList.add(0,400);
        System.out.println(seqList.search(110));
    }
    //检验冒泡排序法的方法
    private static void testBubbleSort(){
            int[] arr = {3,4,2,1,5};
            //调用，导入alt + insert。
             bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //检验二分法查找,必须是有序数组。
    public static void testBinarySearch(){
            int[] arr1 = {0,1,2,3,4,5,6,7,8,11,55};
        System.out.println( binarySearch(arr1,-1));
    }
    //底下是在main方法中直接调用上边写的那些方法
    public static void main(String[] args) {
            testAdd();
            testContains();
            testSearch();
            testBubbleSort();
            testBinarySearch();
    }
}

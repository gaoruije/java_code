package java_1008;

import java_1007.SeqList;
import java.util.Arrays;
import static java_1008.ArrayList.reverse;

public class test {
    //插入元素
    private static void testAdd(){
        SeqList seqList = new SeqList();
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
    //1，测试数组逆序的代码.
    public static void testRevers() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        //调用方法，并导入alt + enter
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
    //2,测试删除第一个出现的元素
    private static void testToRemove(){
        SeqList seqList = new SeqList();
        seqList.add(0,1);
        seqList.add(0,2);
        seqList.add(0,3);
        seqList.add(0,4);
        seqList.add(0,5);
        seqList.remove(2);
        seqList.display();
    }

    public static void main(String[] args) {
        testRevers();
        testAdd();
        testToRemove();
    }

}


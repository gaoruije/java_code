package Java_2021_02_19;

import java.util.ArrayList;
import java.util.List;

public class lookOddNumber {
    //题目来源https://leetcode-cn.com/problems/three-consecutive-odds/
    //题目要求：给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：
    // 如果存在，请返回 true ；否则，返回 false 。
    public static void main(String[] args) {
        int[] arr = {1,23,4,6,7,5,3};
        //创建一个arrayList的对象，就是相当于给定了一个框子，后边给框子里边来装东西。
        List<Integer> arrayList = new ArrayList<> ();
        //先插入一些元素，后边才能通过执行来看结果
        arrayList.add(0,8);//要从0号开始插入，不然会越界
        arrayList.add(3);
        arrayList.add(7);
        arrayList.add(5);
       // System.out.println(threeConsecutiveOdds(arr));
        System.out.println(arrayList);
        System.out.println(threeConsecutiveOdds1(arrayList));
    }

    //方法1：单纯的遍历这个数组即可
    private static boolean threeConsecutiveOdds(int[] arr) {
        //对所给的数组进行遍历即可
        for (int i = 0; i < arr.length - 2; i++) {
            //从i开始的连续的三个要是全部是奇数，就返回true
            if (arr[i] % 2 != 0 && arr[i+1] % 2 != 0 && arr[i+2] % 2 != 0 ) {
                return true;
            }
        }
        //要是有一个连续的三个数字能走出循环返回true
        return false;
    }
    //方法2:用顺序表的方式来进行
    private static boolean threeConsecutiveOdds1(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 2; i++) {
            //.get(i)返回的值就是顺序表中的内容
            if (arr.get(i) % 2 != 0 && arr.get(i + 1) % 2 != 0 && arr.get(i + 2) % 2 != 0) {
                return true;
            }
        }
        //要是找完了还是没有，就返回false
        return false;
    }
}

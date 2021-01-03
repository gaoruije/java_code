package Java_2021_01_03;

import java.util.Arrays;

public class AdjustParity0rder {
    public static void main(String[] args) {
        //题目要求：调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
        //1:先创建一组数用数组来保存
        int[] arr = {9, 5, 2, 7, 3, 6, 8, 1, 4};
        Adjust(arr);
        //**这里有一个直接输出数组的方法,就直接将数组输出出来了。
        System.out.println("排序后的结果是：" + Arrays.toString(arr));
    }

    //排序的方法
    public static void Adjust(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            //从前往后找出第一个偶数
            while (left < right && arr[left] % 2 != 0) {//是奇数就跳过
                left++;
            }
            //从后往前找出第一个奇数
            while (left < right && arr[right] % 2 == 0) {//是偶数就跳过
                right--;
            }
            //进行交换
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
}

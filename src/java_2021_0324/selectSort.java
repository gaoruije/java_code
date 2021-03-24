package java_2021_0324;

import java.util.Arrays;

public class selectSort {
    // 1.选择排序法（按照升序的方式进行的）
    // 基本思想：还是先设置已排序区间和待排序区间,让bound从0 开始进行比较
    // [0,bound)表示已排序区间，[bound,length)表示待排序区间
    public static void selectSort(int[] arr) {
        int bound = 0;// 让bound从数组零号下标开始找
        for (; bound < arr.length; bound++) {
            int cur = bound + 1;// 上边的每一个bound表示的是擂主，所以后边要进行每一个元素和擂主之间的较量
            for (; cur < arr.length; cur++) {
                // 里边进行和擂主的比较，要是后边的元素比bound大就要进行交换，
                // 要是没有原来的大，就跳出内层循环，进行下一次的比较
                if (arr[bound] > arr[cur]) {// 擂主打不过cur,cur成为新的擂主
                    swap(arr,bound,cur);
                } else {
                    continue;
                }
                // 注意后边不能加else，跳出循环，要是加上的话，就会跳出这个循环
                // 也就是说吧后边的cur还没有比较完，就结束了，肯定是错的
                // 返回也是可以的，但是要用的是continue，break不行
                // continue 值的是跳出本轮的循环，也就说只是跳过了一次cur，下一次循环还是会进行的
                // 要是break的话，就会直接跳出本轮的循环，导致下一个cur不能进行比较了
            }
        }
    }

    public static void swap(int[] arr,int x,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }



    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package java_2021_0326;

import java.util.Arrays;

public class mergeSort {
    // 归并排序
    public static void mergeSort(int[] arr) {
        _mergeSort(arr,0,arr.length);// 区间让前闭后开
    }

    public static void _mergeSort(int[] arr,int left,int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (right + left) / 2;
        _mergeSort(arr,left,mid);
        _mergeSort(arr,mid,right);
        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr,int left,int mid,int right) {
        if (left >= right) {
            return;
        }
        // 定义一个数组
        int[] temp = new int[right - left];
        int tempIndex = 0;
        int cur1 = left;
        int cur2 = mid;
        while (cur1 < mid && cur2 < right) {
            // 要是cur1对应的值小，插入
            if (arr[cur1] <= arr[cur2]) {
                // 插入的时候，看好是把arr数组中的内容给temp中插入
                temp[tempIndex] = arr[cur1];
                cur1 ++;
                tempIndex ++;
            } else {
                temp[tempIndex] = arr[cur2];
                cur2 ++;
                tempIndex ++;
            }
        }
        // 循环结束后，判断谁还没有遍历完
        while ( cur1 < mid) {
            temp[tempIndex] = arr[cur1];
            cur1 ++;
            tempIndex ++;
        }
        while (cur2 < right) {
            temp[tempIndex] = arr[cur2];
            cur2 ++;
            tempIndex ++;
        }
        // 最后再这个数组拷贝在原来的数组之中，注意拷贝的是left 下标，我们是不断的分成了区间，
        // 每一个区间都是有左和右的，不能一股脑的拷贝给0号位置的下标
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,1,4,0};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

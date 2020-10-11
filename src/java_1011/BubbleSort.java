package java_1011;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        //1,用升序的方法实现冒泡排序法
        int[] arr = {9, 5, 2, 7, 3, 6, 8};
        for (int bound = 0; bound < arr.length - 1; bound++) {
            for (int cur = 0; cur < arr.length - 1 - bound; cur++) {
                if (arr[cur] > arr[cur + 1]) {
                    int tmp = arr[cur];
                    arr[cur] = arr[cur + 1];
                    arr[cur + 1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

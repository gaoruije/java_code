package java_2021_0324;

import java.util.Arrays;

public class bubbleSort {
    // 冒泡排序：(以升序为例)
    // 基本思想：设定一个bound，[0,bound)是已排序区间，[bound,size)是带排序区间
    // 每进行完一次就将一个元素放在了最后边
    public static void bubbleSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            // 里边进行每两个元素之间的比较，
            // for 循环里边要注意：每一次bound的值都会变化的，不要忘记给里边的cur的值减去bound
            // 还有一个要注意的是：上边有个for 循环，走到这里说明已经进入循环了，所以此时的bound
            // 已经变成了1了，后边在设定cur值的时候，不能是bound，不然不能排序第一个元素
            for (int cur = 0; cur < arr.length - 1 - bound; cur++) {
                if (arr[cur] > arr[cur + 1]) {// 交换两个值的内容
                    swap (arr,cur,cur + 1);
                }
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
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

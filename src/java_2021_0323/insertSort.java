package java_2021_0323;

import java.util.Arrays;

public class insertSort {

    // 1.插入排序(以升序为例)
    // 基本思想：将要排序的区间分成已排序区间和待排序区间
    public static void insertSort(int[] arr) {
        // 刚开始的时候将bound设置成1
        // 已排序区间是：[0,bound),待排序区间是[bound,arr.length)
        int bound = 1;// bound 是待排序区间和已排序区间的分界线
        // 外层循环是每一次插入的
        for (; bound < arr.length; bound++) {// 每进行一次循环分界线就像下走一步
            // 里边就进行每次的比较插入过程了
            // 取出带排序区间的最开始值
            int v = arr[bound];// 待排序区间的开始值
            int cur = bound - 1;// 已排序区间的最后一个值
            // 这个循环在比较查入的元素和已排序区间内的所有元素的大小关系
            for (; cur >= 0; cur--) {
                if (arr[cur] > v) {// 说明 V 应该插入到cur的前边
                    arr[cur + 1] = arr[cur];// 将cur 位置的元素向后搬运
                } else {// 不用再进行搬运
                    break;
                }
            }
            // 最后将v元素插入到cur的后边
            arr[cur + 1] = v;
        }
    }

     // 2.希尔排序
     // 基本思想：对插入排序进行了改进，进行了希尔分组,采用希尔序列来进行分组
    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;// gap是几就分为几组
        while (gap >= 1) {// 只要不是最后的那个一组分的，一直循环排序
            _shellSort(arr,gap);
            // 每进行一次将gap变为原来的一般即可
            gap /= 2;
        }
    }

    public static void _shellSort(int[] arr,int gap) {
        int bound = gap;
        for (; bound < arr.length; bound++) {
            int v = arr[bound];
            int cur = bound - gap;
            for (; cur>= 0; cur -= gap) {
                if (arr[cur] > v) {
                    // 要进行搬运
                    arr[cur + gap] = arr[cur];
                } else {
                    // 不用进行交换，直接跳出循环
                    break;
                }
            }
            arr[cur + gap] = v;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        //insertSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

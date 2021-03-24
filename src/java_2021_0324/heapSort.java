package java_2021_0324;

import java.util.Arrays;

public class heapSort {
    // 题目要求：堆排序来进行对一组数据的升序排序
    public static void heapSort(int[] arr) {
        // 1.要想进行堆排序先要进行建堆
        createHeap(arr);
        // 2.交换堆顶元素和最后一个元素，并进行对每个元素进行向下调整
        int heapSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            swap(arr,heapSize - 1,0);// 交换两个元素
            // 每交换完一次，先进行堆的长度-1操作
            heapSize--;
            // 交换完成之后，堆的样子就会变化的，在从0号位置进行向下调整
            shiftDown(arr,heapSize - 1,0);
        }
    }

    // 3.建堆代码
    public static void createHeap(int[] arr) {
        // 在进行建堆的时候，要进行想下调整，只需要从最后一个孩子的上一个父亲节点开始即可
        for (int i = (arr.length - 1 -1) / 2; i >= 0; i--) {
            // 对每一个元素进行向下调整
            shiftDown(arr,arr.length,i);
        }
    }

    // 4.向下调整代码
    public static void shiftDown(int[] arr,int size,int index) {
        // 设定孩子的起始位置
        int parent = index;
        int child = 2 * parent + 1;// 父亲与孩子的关系
        while (child < size) {// 孩子的下标小于数组的长度的话就进行调整
            // 调整左右孩子，将较大值定义为child
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child  = child + 1;
            }
            // 比较父亲和孩子的大小
            if (arr[parent] < arr[child]) {
                // 交换父亲和孩子的位置
                swap (arr,parent,child);
            } else {// 父亲比孩子大，直接跳过
                break;
            }
            // 更新孩子的位置
            parent = child;
            child = 2 * parent + 1;
        }
    }

    // 5.交换的方法
    public static void swap(int[] arr,int x,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,5,6,4,1,7,9,2,8,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

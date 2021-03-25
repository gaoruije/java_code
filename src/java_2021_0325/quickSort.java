package java_2021_0325;

import java.util.Arrays;

public class quickSort {
    // 快速排序法
    // 基本思想：找一个基准值，然后弄两个用引用来控制左边和右边的下标
    public static void quickSort(int[] arr) {
        // 用一个_quickSort方法来辅助进行快排,left 和 right 是闭区间
        _quickSort(arr,0,arr.length - 1);
    }

    public static void _quickSort(int[] arr,int left,int right) {
        while (left >= right) {
            // 里边要不是空区间要不只有一个元素直接返回即可
            return;
        }
        // 否则进行从左给右找元素和从右给左找元素,这里要找到那个分割线的下标
        int index = partition(arr,left,right);
        // 递归处理左区间
        _quickSort(arr,left,index - 1);
        // 递归处理右边的区间
        _quickSort(arr,index + 1,right);
    }

    // 这个方法就是为了交换左边和右边的元素，获取重合位置的下标
    public static int partition (int[] arr,int left,int right) {
        // 先将这个基准值记录下来
        int v = arr[right];
        int l = left;
        int r = right;
        // 这里的条件不能加等号，要是相等的时候就说明已经遍历完成了
        while (l < r) {
            // 从左给右找第一个比基准值大的元素
            while (l < r && arr[l] <= v) {// 因为是想找大于基准值的，所以这里要是arr[l] < 基准值
                // 就跳过，当出这个循环的时候，就说明一种情况是：l和r重合了，
                // 一种情况就是找到了那个第一个大于基准的数,还有要注意的是：要带上等号
                l++;
            }
            // 从右给左找第一个比基准值小的数字
            while (l < r && arr[r] >= v) {
                r--;
            }
            // 经过上边的两个循环之后，就找到了这两个值了，下边进行交换
            swap (arr,l,r);
        }
        // 这里走完后就说明找到了那个重合的位置了，交换基准值和重合位置下标的值
        swap (arr,l,right);
        // 最后将这个重合的下标返回出去
        return r;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,12,2,7,3,13,8,1,4,0,-1,6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

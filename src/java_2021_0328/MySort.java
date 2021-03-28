package java_2021_0328;

import java.util.Arrays;

public class MySort {
    // 练习基于比较的七中常见的排序算法(全部默认按升序来进行)
    // 1.插入排序法
    public static void insertSort(int[] arr) {
        // 已排序区间[0,bound),待排序区间[bound,arr.length)
        int bound = 1;
        for (; bound < arr.length; bound ++) {
            int temp = arr[bound];
            int cur = bound - 1;
            for (; cur >= 0; cur --) {// cur是从后给前来进行寻找的
                if (arr[cur] > temp) {// 要保证稳定性不能带等于号
                    // 进行搬运
                    arr[cur + 1] = arr[cur];
                } else {
                    break;
                }
            }
            // 每进行完一次就进行一次元素的合适位置的插入
            arr[cur + 1] = temp;
        }
    }

    // 2.希尔排序法
    public static void shellSort(int[] arr) {
        // 设置希尔序列
        int gap = arr.length / 2;
        while (gap >= 1) {// 要是分组的个数大于等于1就进行分组然后，进行插入排序
            _shellSort(arr,gap);
            // 进行一次循环之后，gap的位置要改变，要在循环里边改变的，注意gap改变的位置
            gap /= 2;
        }
    }

    public static void _shellSort(int[] arr,int gap) {
        int bound = gap;
        for (; bound < arr.length; bound ++) {
            int temp = arr[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (arr[cur] > temp) {// 为了保证稳定性，不能带等号
                    arr[cur + gap] = arr[cur];
                } else {
                    break;
                }
            }
            // 进行元素的插入
            arr[cur + gap] = temp;
        }
    }

    // 3.选择排序法
    public static void selectSort(int[] arr) {
        int bound = 0;
        for (; bound < arr.length; bound ++) {
            int cur = bound + 1;
            for (; cur < arr.length; cur++) {
                if (arr[cur] < arr[bound]) {// 这里注意为了稳定性不能带等号
                    // 交换两个位置
                    swap(arr,cur,bound);
                }
            }
        }
    }

    // 4.堆排序
    public static void heapSort(int[] arr) {
        // 1.先针对给的数组进行建堆操作
        createHeap(arr);
        // 2.建完堆后，交换堆顶和堆的最后一个最后一个元素，并删除这个元素
        int heapSize = arr.length;// 时刻记录数组的下标
        for (int cur = 0; cur < arr.length; cur ++) {
            // 先交换堆的第一个元素和最后一个元素
            swap(arr,heapSize - 1,0);
            // 交换完成后，刚一交换之后，Size的长度就要改变，真正的成为一个新堆的时候，在进行向下调整
            heapSize --;
            // 将数组的长度调整好之后，就进行向下调整
            shiftDown(arr,heapSize,0);
        }
    }

    public static void createHeap(int[] arr) {
        // 从后给前遍历数组，依次进行向下调整，从最后一个非叶子节点调整即可
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            // 上边的第一次减一指的是找到堆最后一个元素的下标，再减一除以二，
            // 表示的是最后一个非叶子节点
            shiftDown(arr,arr.length,i);
        }
    }

    public static void shiftDown(int[] arr,int size,int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            if (arr[parent] < arr[child]) {
                swap(arr,parent,child);
            }
            // 每进行完一次循环要进行一次parent值的修改
            parent = child;
            child = 2 * parent + 1;
        }
    }

    // 5.冒泡排序法
    public static void bubbleSort(int[] arr) {
        int bound = 0;
        for (; bound < arr.length; bound ++) {
            for (int cur = 0; cur < arr.length - bound - 1; cur ++) {
                if (arr[cur] > arr[cur + 1]) {
                    swap(arr,cur, cur + 1);
                }
            }
        }
    }

    // 6.快速排序法
    public static void quickSort(int[] arr) {
        _quickSort(arr,0,arr.length - 1);// 排序的区间设置成前闭后闭
    }

    public static void _quickSort(int[] arr,int left,int right) {
        // 只剩下一个元素的时候就不用再进行递归了
        if (right - left <= 0) {// 要是right和left重合了，或者之间没有位置了，即返回
            return;
        }
        // 如果不是这样，就进行partition操作
        int index = partition(arr,left,right);
        // 完成之后递归处理区间
        _quickSort(arr,left,index - 1);
        _quickSort(arr,index + 1,right);
    }

    public static int partition(int[] arr,int left,int right) {
        // 选取基准值
        int temp = arr[right];
        int l = left;
        int r = right;
        while (l < r) {
            // 从左给右找第一个比基准值大的数字
            while (l < r && arr[l] <= temp) {
                l ++;
            }
            // 同理从右给左找第一个比基准值小的元素
            while (l < r && arr[r] >= temp)  {
                r--;
            }
            // 找到之后，进行交换两个值
            swap(arr,l,r);
        }
        // 进行完一次循环之后，找到了重合位置下标，交换下标，并返回
        swap(arr,l,right);
        return l;
    }

    // 7.归并排序
    public static void mergerSort(int[] arr) {
        // 牵扯到递归，我们辅助递归方法
        _mergerSort(arr,0,arr.length);// 区间是前闭后开的

    }

    public static void _mergerSort(int[] arr,int left,int right) {
        while (right - left <= 1) {// 最好情况下他们两个挨着
            return;
        }
        // 左右递归处理两个区间
        int mid = (left + right) / 2;
        _mergerSort(arr,left,mid);
        _mergerSort(arr,mid,right);
        // 进行将两个有序数组的合并
        merge(arr,left,mid,right);

    }

    public static void merge(int[] arr,int left,int mid,int right) {
        // 准备一个用来从放排列后的数字的数组
        int[] temp = new int[right - left];
        // 后边要进行给新的数组里边插入元素，时刻记录数组的插入下标
        int tempIndex = 0;
        int cur1 = left;
        int cur2 = mid;
        while (cur1 < mid && cur2 < right) {
            // 下边要带上等号，因为cur1总是在左边的，要是它相等的话应先被插入。还是为了稳定性
            if (arr[cur1] <= arr[cur2]) {
                temp[tempIndex] = arr[cur1];
                cur1 ++;
                tempIndex ++;
            } else {
                temp[tempIndex] = arr[cur2];
                cur2 ++;
                tempIndex ++;
            }
        }
        // 循环结束后，看看谁还没有被插完
        while (cur1 < mid) {
            temp[tempIndex] = arr[cur1];
            cur1 ++;
            tempIndex ++;
        }
        while (cur2 < right) {
            temp[tempIndex] = arr[cur2];
            cur2 ++;
            tempIndex ++;
        }
        // 最后把新的数组拷贝给原来的数组中
        for (int cur = 0; cur < temp.length; cur ++) {
            arr[left] = temp[cur];
            left ++;
        }
    }

    public static void swap(int[] arr,int x,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8,4,1,0};
        //insertSort(arr);
        //shellSort(arr);
        //selectSort(arr);
        //heapSort(arr);
        //bubbleSort(arr);
        //quickSort(arr);
        mergerSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

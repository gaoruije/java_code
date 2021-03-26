package java_2021_0325;

import java.util.Arrays;

public class MySort {
    // 1.插入排序法(以升序为例)，是稳定的排序
    // 基本思想：将区间分成待排序区间和已排序区间，用上两个循环
    public static void insertSort(int[] arr) {
        // 区间的设定：待排序区间[0,bound),已排序区间[bound,arr.length)
        int bound = 1;
        for (; bound < arr.length; bound++) {
            int cur = bound - 1;// 将
            // 将bound位置的元素记录下来，方便后边进行插入
            int temp = arr[bound];
            for (; cur >= 0; cur--) {
                if (arr[cur] > temp) {// 不能去等号，为了稳定性的考虑
                    // 进行搬运
                    arr[cur + 1] = arr[cur];
                } else {// 一旦找到那个比cur小的值，cur前边的数据也一定比arr[bound]小，直接结束循环即可
                    break;
                }
            }
            // 每进行完一次循环，将arr[bound]插入到合适的位置上
            arr[cur + 1] = temp;
        }
    }

    // 2.希尔排序(还是以升序为例)，bound下标的元素和前边的元素进行比较。
    // 基本思想：和插入排序基本相同，就是给数组进行了分组，gap的值是几，就有几组，
    // 直到最后是为一组的时候就相当于的是插入排序

    public static void shellSort(int[] arr) {
        int gap = arr.length / 2;
        while (gap >= 1) {// 只要组数是大于1的，就进行分组
            // 借助方法
            _shellSort(arr,gap);
            // 每进行完一次排序要让gap的值变为原来的一半
            gap /= 2;
        }

    }

    public static void _shellSort(int[] arr,int gap) {
        int bound = gap;// 从gap位置开始找起
        for (; bound < arr.length; bound++) {
            // 搞个东西记录bound位置的元素，方便后边进行插入
            int temp  = arr[bound];
            int cur = bound - gap;
            for (; cur >= 0; cur -= gap) {
                if (arr[cur] > temp) {// 想要升序,要是cur位置的值比temp大，就给后进行搬运
                    // 进行元素的搬运
                    arr[cur + gap] = arr[cur];
                } else {
                    break;
                }
            }
            // 将arr[bound]的值进行插入
            arr[cur + gap] = temp;
        }
    }

    // 3.选择排序法(升序为例)，以打擂台的方法进行(擂主跟后边的元素进行较量)
    public static void selectSort(int[] arr) {
        int bound = 0;// 从零号位置开始进行
        for (; bound < arr.length; bound++) {
            // 里层循环表示的是，擂主后边的每一个元素和擂主的较量
            int cur = bound + 1;
            for (; cur < arr.length; cur++) {
                if (arr[cur] < arr[bound]) {// 进行交换
                    swap(arr,bound,cur);
                } else {
                    continue;
                }
            }
        }
    }
    public static void swap(int[] arr,int x,int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    // 4.堆排序
    public static void heapSort(int[] arr) {
        // 1.进行建堆操作
        createHeap(arr);// 从后往前依次向下调整
        // 2.将堆顶元素和最后一个元素进行交换，并删除最后一个元素
        int heapSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            swap(arr,0,heapSize - 1);
            //删除完成后，进行删除操作，并有上给下向下调整
            heapSize--;
            shiftDown(arr,heapSize,0);
        }
    }

    public static void createHeap(int[] arr) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
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
                swap(arr,child,parent);
            }
            // 没进行一次循环，parent的位置更新一次
            parent = child;
            child = 2 * parent + 1;
        }
    }

    // 5.冒泡排序法 (升序进行)
    public static void bubbleSort(int[] arr) {
        for (int bound = 0; bound < arr.length; bound++) {
            for (int cur = 0; cur < arr.length - bound - 1; cur++) {
                if (arr[cur] > arr[cur + 1]) {
                    swap(arr,cur,cur + 1);
                }
            }
        }
    }

//    // 6.快速排序
//    public static void quickSort(int[] arr) {
//        // 辅助递归方法
//        _quickSort(arr,0,arr.length - 1);
//    }
//
//    public static void _quickSort(int[] arr,int left,int right) {
//        while (right - left < 1) {
//            return;
//        }
//        // 要不就得进行partition操作
//        // 用一个变量将partition的值记录下来，这个值就是left和right重合的位置
//        int index = partition(arr,left,right);
//        // 递归左右区间
//        _quickSort(arr,left,index - 1);
//        _quickSort(arr,index + 1,right);
//    }
//
//    public static int partition(int[] arr,int left,int right) {
//        // 选取基准值
//        int v = arr[right];
//        int l = left;
//        int r = right;
//        while (l < r) {
//            // 从左给右找一个比基准值大的数字
//            while (l < r && arr[l] <= v) {
//                l++;
//            }
//            // 总右给左找出第一个比基准值小的数字
//            while (l < r && arr[r] >= v) {
//                r--;
//            }
//            // 交换两个左边和右边的元素
//            swap(arr,l,r);
//        }
//        // while循环之后，左边和右边的值就重合了
//        // 交换重合位置和基准值，并返回下标
//        swap(arr,l,right);
//        return l;
//    }

    // 快速排序法
    public static void quickSort(int[] arr) {
        // 辅助快排方法
        _quickSort(arr,0,arr.length - 1);// 区间设置成前闭后闭
    }

    public static void _quickSort(int[] arr,int left,int right) {
        if (right - left <= 0) {
            return;
        }
        // 否则进行partition操作
        int index = partition(arr,left,right);
        // 对左右区间进行递归
        _quickSort(arr,left,index - 1);
        _quickSort(arr,index + 1,right);
    }

    public static int partition(int[] arr,int left,int right) {
        // 记下基准值
        int temp = arr[right];
        int l = left;
        int r = right;
        while (l < r) {// 要是left和right没有重合，则进行循环
            // 从左给右找第一个比基准值大的数字
            while (l < r && arr[l] <= temp) {
                l++;
            }
            // 总右给左找第一个比基准值小的数字
            while (l < r && arr[r] >= temp) {
                r--;
            }
            // 找到了两个值进行交换
            swap(arr,l,r);
        }
        // 出了这个循环就说明left和right重合了，交换基准值和重合位置的值
        swap(arr,l,right);
        // 最后将重合的下标返回出去
        return l;
    }

    // 7.递归排序
    // 基本思想：递归处理左右有序区间，给两个有序的数组区间进行归并处理
    public static void mergeSort(int[] arr) {
        // 牵扯到递归，用一个辅助方法来进行
        _mergeSort(arr,0,arr.length);// 这个区间是前闭后开的
    }

    public static void _mergeSort(int[] arr,int left,int right) {
        if (right - left <= 1) {// 要是里边只有一个元素的时候，返回
            return;
        }
        // 要不然进行归并数组的操作
        int mid = (left + right) / 2;// 找出那个中间的下标，方便后边进行区间的设定
        _mergeSort(arr,left,mid);
        _mergeSort(arr,mid,right);
        merge(arr,left,mid,right);
    }

    public static void merge(int[] arr,int left,int mid,int right) {
        // 要将数组中的较小的元素放在一个新的数组里边，先new一个
        if (left >= right) {
            return;
        }
        int[] temp = new int[right - left];
        // 从数组的两个边边进行比较,因为区间是前闭后开的所以这样设计正好不用考虑下标的影响
        // 记录数组插入值的起始位置
        int tempIndex = 0;
        int cur1 = left;
        int cur2 = mid;
        while (cur1 < mid && cur2 < right) {
            // 因为归并是稳定的排序，要带上等于号，要是出现相同的数字，cur1里边的那个数字是前边的
            // 所以要将它先放在数组里边，保证稳定性
            if (arr[cur1] <= arr[cur2]) {
                // 将cur1插入
                temp[tempIndex] = arr[cur1];
                tempIndex ++;
                cur1 ++;
            } else {// 将cur2里边的值插入
                temp[tempIndex] = arr[cur2];
                tempIndex ++;
                cur2 ++;
            }
        }
        // 一轮走完之后，看一下谁的里边还有元素
        while (cur1 < mid) {// 插入cur1里边剩余的元素
            temp[tempIndex] = arr[cur1];
            tempIndex ++;
            cur1 ++;
        }
        while (cur2 < right) {// 插入cur2里边剩余的元素
            temp[tempIndex] = arr[cur2];
            tempIndex ++;
            cur2 ++;
        }
        // 完成之后再将临时数组中的元素拷贝到原数组中
        for (int i = 0; i < temp.length; i++) {// 是将temp数组中的元素给原来的数组进行拷贝
            arr[left] = temp[i];// 注意拷贝的时候不能给0号下标的位置来拷贝，
            // 必定我们的区间不是只有0要给left里边进行拷贝
            left ++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {3,5,7,8,2,4,0,1,9,6};
        //insertSort(arr);
        //shellSort(arr);
        //selectSort(arr);
        //heapSort(arr);
        //bubbleSort(arr);
        //quickSort(arr);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

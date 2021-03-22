package java_2021_0322;

public class Heap {
    // 自己实现一个堆：
    // 核心操作：向下调整，拿着堆顶的元素和左右孩子进行比较，要是父亲没有孩子大，将较大的孩子和父亲进行交换
    // 直到达到所有的要求为止
    // 1.先写出核心操作：向下调整代码
    public static void shiftDown(int[] arr,int size,int index) {// size 值得是有效元素的位置
        // 向下调整的时候，传入的参数是一个数组，只是将数组进行了组织
        int parent = index;
        int child = 2 * parent + 1;// 孩子和父亲的关系
        // 进行判定，看看child 的值是否在数组的范围内
         while (child < size) {// 满足条件，进行向下调整
             // 先看左右孩子哪个大，将大的定义为child
             if (child + 1 < size && arr[child + 1] > arr[child]) {// 左右孩子的关系，要是右边比左边大了，进行交换
                 // 将较大的值给child
                 child = child + 1;
             }
             // 上边保证了child是孩子中最大的了，下边进行判定孩子和父亲的关系是否满足大堆要求
             if (arr[child] > arr[parent]) {
                 // 进行交换
                 int temp = arr[child];
                 arr[child] = arr[child + 1];
                 arr[child + 1] = temp;
             } else {// 符合大堆要求不用交换，直接跳出，进行下轮循环
                 break;
             }
             // 没进行一次循环进行一次条件的更新
             parent = child;
             child = 2 * parent + 1;
        }
    }
    // 2.进行建堆操作
    // 基本思想：从后往前进行遍历数组，每个元素都进行向下调整
    public static void createHeap(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            shiftDown(arr,arr.length,i);
        }
    }
}

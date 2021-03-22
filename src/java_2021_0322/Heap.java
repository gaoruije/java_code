package java_2021_0322;

public class Heap {
    // 自己实现一个堆：
    // 核心操作：向下调整(从上给下走)，拿着堆顶的元素和左右孩子进行比较，要是父亲没有孩子大，将较大的孩子和父亲进行交换
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

    // 2.向下调整进行建堆操作
    // 基本思想：从后往前进行遍历数组，每个元素都进行向下调整
    public static void createHeap(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            shiftDown(arr,arr.length,i);
        }
    }

    // 3.向上调整(从下给上走),只需要比较孩子和父亲的关系，不用比较左右孩子的关系的,还是以大堆为例。
    public static void shiftUp(int[] arr,int size,int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0) {// 当child 小于零的时候，就已经调整到最上边了，不用再进行调整了
            if (arr[parent] < arr[child]) {// 父亲小于孩子，进行交换
                int temp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = temp;
            } else { // 合适着嘞。不用管，直接跳出
                break;
            }
            // 没进行一次更新一次条件
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    // 4.给堆中插入元素
    // 基本操作：先将要插入的元素放在数组的最后边，然后再进行向上调整
    public int[] arr = new int[100];
    public int size = 0;
    public  void offer(int val){
        if (size >= arr.length) {// 里边已经满了，不能进行插入了
            return;
        }
        // 先将这个元素插入到数组的最后一个位置
        arr[size] = val;
        size++;
        // 把最后的元素进行向上调整
        shiftUp(arr,size,size -1);// 注意下标和长度的下标区别，差了个1.
    }

    // 5.采用向上调整进行建堆（以大堆为例）
    // 基本思想：循环遍历数组，把元素通过offer方法插入，然后再进行向上调整即可
    public  void createHeap2(int[] arr) {
        // 进行遍历数组，把元素通过offer的方法插入进去
        for (int x : arr) {
            // 每插入一次进行一次向上调整
            offer(x);
        }
    }
}

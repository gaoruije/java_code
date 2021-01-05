package java_2021_01_05;


import java.util.Arrays;

public class ArrayHomework {
    public static void main(String[] args) {
//        1,实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(avg(arr));
//        2,实现一个方法 sum, 以数组为参数, 求数组所有元素之和.
//        System.out.println(sum(arr));
//        3,实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 ,
//         并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
//        transform(arr);
//        4,实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
//        printArray (arr);
//        5,创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
//        int[] arr = new int[100];//new一个长度为100的数组。
//        arrayAssignment(arr);
//        6,冒泡排序,创建的方法是BubbleSort(),升序来进行
//        int[] arr = {9,5,2,7,3,6,8,1,4,0};
//        BubbleSort(arr);
//        //7,检查数组是否有序，（按递增来进行）
//        int[] arr1 = {9,5,2,7,3,6,8};
//        CheckArray0der(arr);
//        CheckArray0der(arr1);
//        8,给定一个有序整型数组, 实现二分查找,返回要查找的数字的下标.
//        前提是数组是有序的。
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(BinarySearch(5,arr));//能找见的验证
//        System.out.println(BinarySearch(8,arr));//找不见返回-1
//        9,实现一个方法 copyOf, 对一个整型数组进行拷贝, 得到一个新的数组.
//        copyOf(arr);
        //10,实现一个方法 toString, 把一个整型数组转换成字符串. 例如数组 {1, 2, 3} ,
        // 返回的字符串为 "[1, 2, 3]", 注意逗号的位置和数量.
        int[] arr = {1,2,3,4,5,6};
        ToString(arr);
    }

    public static void ToString(int[] arr) {//注意类型，后边是要返回字符串的，用的是Sring.
        //先弄一个能存字符串的对象
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            //逗号加到倒数第二个以及其以前的每个数字的后边即可，最后一个不用加。
            if (i != arr.length - 1) {
                result += ",";
            }
        }
        //for循环完成后，再加上最后一个]即可。
        result += "]";
        System.out.println(result);
    }

    public static void copyOf(int[] arr) {
        //先创建一个和原来的数组长度一样的数组。
        int[] arr1 = new int[arr.length];
        //将数组arr中的依次填写到arr1中去
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        System.out.println("原来的数组arr是：" + Arrays.toString(arr));
        System.out.println("拷贝后的数组arr1是：" + Arrays.toString(arr1));
    }

    public static int BinarySearch(int ToFind,int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        //要加上等号，有可能你要找的那个数就在最中间的位置。
        while (left <= right) {
            //找中间的下标
            int mid = (left + right)/2;
            //进行比较。
            if (ToFind < arr[mid]) {//说明要找的元素在左边。
                right --;
            } else if (ToFind > arr[mid]) {//说明要找的元素在右边
                left ++;
            }else {
                return mid;
            }
        }
        //要是进行完了上边的流程还没有返回值就说明没有找见，返回-1.
        return -1;
    }

    public static void CheckArray0der(int[] arr) {
        if (Isoder(arr)) {
            System.out.println("此数组有序");
        } else {
            System.out.println("此数组无序");
        }
    }

    public static boolean Isoder(int[] arr) {//只会返回一个结果
        for (int i = 0; i < arr.length - 1; i++) {//注意i的范围，因为底下有个i + 1.
            if (arr[i] > arr[i + 1]) {
                //有一个不满足条件则说明数组已经是无序的
                return false;
            }
        }
        //依次遍历完所有的元素后，说明数组是有序的
        return true;
    }

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i <arr.length; i++) {//外层的循环
            for (int j = 0 ; j < arr.length - i- 1; j++) {//内层的循环
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void arrayAssignment(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
          System.out.println(Arrays.toString(arr));
    }

    public static int sum(int[] arr) {
        int result = 0;
        for (int i = 0;i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }

    public static double avg(int[] arr) {
        double result = 0.0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        //最后返回数组所有值的平均值，
        return (result/arr.length);
    }
}

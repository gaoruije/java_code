import java.util.Arrays;
import java.util.Scanner;
public class CodePractice {
    public static void main(String[] args) {

//        //Java中先得来个这个。三个英文单词
//随后就是导入输入的类
//import java.io.BufferedReader;//应该是要输入数字就要创建一个Buffer
//import java.io.InputStreamReader;
//import java.io.IOException;
//        public class Main {
//            public static void main (String[] args) throws IOException {
//                BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
//                //搞了一个能多组输入的数组。
//                String[] arr = br.readLine().split(" ");
//                //进行输出
//                System.out.println ("score1=" + arr[0] + ",score2=" + arr[1] +",score3=" +arr[2]);
//            }
//        }
        //1,输出一个范围内的水仙花数字
       // PrintDaffodils(1,999);
        //2，数组逆序
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        ArrayReverse(arr);
        //3,冒泡排序,默认按照降序来排列
        int[] arr2 = {9,5,2,7,3,6,8,1,4,0};
        //BubbleSort(arr2);
        //4,二分查找,前提是数组是有序的哦。
        //System.out.println(BinarySearch(7,arr));
        //5，检查数组是否是有序的,默认数组是升序的
        //false表示数组是无序的，true表示数组是有序的。
        //System.out.println(CheckArrayOrder(arr2));
        //6,找数组中的最小元素
        FindMinNumber(arr2);
        //7,对数组进行奇偶排序，奇数在前，偶数在后，不关心数字的大小。
        ArraySort(arr);
    }


    public static void ArraySort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        //想一下，要是左右相等的时候，不用再交换了。
        while (left < right) {
            //从前往后找出第一个偶数
            while (left < right && arr[left] % 2 != 0) {//表示的是，要是奇数就跳过。
                left ++;
            }
            //从后往前找出第一个奇数
            while (left < right && arr[right] % 2 == 0) {//表示找见偶数就跳过直到找奇数为止
                right --;
            }
            //交换找见的两个数字
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        //对数组进行输出
        System.out.println(Arrays.toString(arr));
    }
    public static void FindMinNumber(int[] arr) {
        //这里我们规定先让它从第一个数字来找，规定一个最小的值，然后依次和它比较，哟啊还小，就赋值给它
        int Min = arr[0];
        //从第二个比较就可以了。
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < Min) {
                Min = arr[i];
            }
        }
        System.out.println("数组中的最小值是： " + Min);
    }
    public static boolean CheckArrayOrder(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            //要是出现一个前一个比后一个大，则说明这个数组已经不是有序的了，返回false
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        //走完了for循环说明数组是有序的。
        return true;
    }
    public static int BinarySearch(int ToFind,int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        //注意while内的条件，就是注意等号。
        while (left <= right) {
            int mid = (left + right) / 2;
            if (ToFind < arr[mid]) {//说明在左边
                right = mid - 1;
            } else if (ToFind > arr[mid]) {//说明在右边
                left = mid + 1;
            } else {//说明找见了
                return mid;
            }
        }
        //要是走完上边的循环还是没有找见的话，就返回一个 -1.
        return -1;
    }

    public static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void PrintDaffodils(int begin, int end) {
        int count = 0;
        for (int i = begin; i <= end; i++) {
            if(IsDaffodils(i)) {//判断是否是水仙花的方法
                System.out.println(i);
                count ++;
            }
        }
        System.out.println("一共有" + count + "个。");
    }
    public static boolean IsDaffodils(int number) {
        //提取个位
        int gewei = number % 10;
        //提取十位
        int shiwei = number / 10;
        shiwei = shiwei % 10;
        //提取百位
        int baiwei = number / 100;
        baiwei = baiwei % 10;
        //下边有一个求立方的方法
        if (Cube(gewei) + Cube(shiwei) + Cube(baiwei) == number) {
            return true;
        } else {
            return false;
        }
    }

    public static int Cube(int i) {
        i = i * i * i;
        return i;
    }

    //数组逆序
    public static void ArrayReverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
        System.out.println(Arrays.toString(arr));
    }
}

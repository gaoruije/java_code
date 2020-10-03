package java_1003;

import java.util.Arrays;

public class PracticeArray {
    public static void main(String[] args) {
        //1,找出数组之中的最大值,思想还是先写方法再调用。
        int[] arr = {9,5,2,7,3,6,8};
        int result = Max(arr);
        System.out.println(result);
        //2,自己练习求数组中的最小值
        int[] arr1 = {9,5,2,7,3,6,8};
        int result1 = Min(arr1);
        System.out.println(result1);
        //3,求数组中的所有元素的平均值，还是底下先创建方法，这里调用
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        double result2 = Avg(arr2);
        System.out.println(result2);
        //4,查找数组中的指定元素的下标。
        int[] arr3 = {1,2,3,4,5,};
        int result3 = Find(arr3,7);
        System.out.println(result3);
        //5,查找数组中指定的元素，并返回元素值
        int[] arr4 = {1,23,45,67,86};
        int result4 = Find1(arr4,45);
        System.out.println("你要找的元素是："+result4);
        //6,二分法查找要找元素的下标，还是先写方法再调用。
        int[] arr5 = {1,2,3,4,5,6,7,8,9};
        //第一种是可以用result来表示这个结果
        int result5 = BinarySearch(arr5,67);
        //第二种是可以用pos来接收这个结果
        int pos = BinarySearch(arr5,9);
        System.out.println("你要找的元素的下标是："+result5);
        System.out.println("你要找的元素下标是："+pos);
        //7,检查数组是否有序性(升序的)
        int[] arr6 = {1,2,3,4,5,6,7};
        boolean result6 = isSorted(arr6);
        System.out.println(result6);
        //8,检查数组是否有序（降序的）
        int[] arr7 = {7,6,9,4,3,2,1};
        boolean result7 = isSorted1(arr7);
        System.out.println(result7);
        //9,数组排序（冒排序法）,按降序来排列的
        int[] arr8 = {9,5,2,7,3,6,8};
        BubbleSort(arr8);
        System.out.println(Arrays.toString(arr8));
    }
    //求数组最大值的方法，为了上边直接调用
    public static int Max(int[] arr){
        int arena = arr[0];//指的是先创建了一个擂台，也就是数组中的第一个元素。
        for(int i = 1;i < arr.length;i++){//依次循环遍历所有的数组即可
            if(arr[i] > arena){
                arena = arr[i];
            }
        }
        return arena;
    }
    //求数组中的最小值的方法，和上边基本相同
    public static int Min(int[] arr){
        int a = arr[0];
        for(int i = 1;i < arr.length;i++){
            if(a > arr[i]){
                a = arr[i];
            }
        }
        return a;
    }
    //求数组中的算有元素的平均值得方法
    public static double Avg(int[] arr){
        double sum = 0;
        for(int i = 0;i < arr.length;i++){//这里会进行隐式转换，就是int转double。
            sum += arr[i];
        }
        return sum/arr.length;
    }
    //求数组中的指定元素的下标方法
    public static int Find(int[] arr,int toFind){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == toFind){
                return i;
            }
        }
        return -1;
    }
    //求数组中的指定值的方法
    public static int Find1(int[] arr,int toFind){
        for(int i = 0;i < arr.length;i++){
            if(arr[i] == toFind){
                return arr[i];
            }
        }
        return -1;
    }
    //用二分法查找指定元素的下标
    public static int BinarySearch(int[] arr,int toFind){
        int left = 0;
        int right = arr.length -1;
        while(left <= right){
            //先找到中间位置mid
            int mid = (left + right)/2;
            if(toFind < arr[mid]){//一定注意，小于的是arr[mid].
                //往左边找
                right = mid - 1;
            }else if(toFind > arr[mid]){//一定注意大于的是arr[mid].
                left = mid + 1;
            }else {
                return mid;
            }
        }//将整个区间找完了，就可以返回-1了，就是表示没有找到。
        return -1;
    }
    //这里我们创建了一个方法来比较二分法查找数组中指定元素值的下标到底有多快。
    public static int[] makeLargeArray(){
        int[] result = new int[10000];
        for(int i = 0; i < result.length; i ++){
            //这里是将下标作为了返回值，也就满足了升序的要求了。
            result[i] = i;
        }
        return result;
    }
    //创建一个检查数组是否有序（升序）的方法,如果有序则返回的值是true，否则返回false
    public static boolean isSorted(int[] arr){
        //先遍历数组
        for(int i = 0; i < arr.length-1; i++){
            //然后再找反例,升序排列为例
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
    //创建一个检查数组是否有序（降序）的方法，若是则返回true，否则返回false。
    public static boolean isSorted1(int[] arr){
        //还是先遍历数组，
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] < arr[i+1]){
                return false;
            }
        }
        return true;
    }
    //冒泡排序的方法,按降序的排列的。
    public static void BubbleSort(int[] arr){
       for(int cur = 0; cur < arr.length-1; cur ++){
           for(int bound = 0; bound < arr.length-1-cur; bound++){
               if(arr[bound] < arr[bound+1]){
                   int tmp = arr[bound];
                   arr[bound] = arr[bound+1];
                   arr[bound+1] = tmp;
               }
           }
       }
    }
}

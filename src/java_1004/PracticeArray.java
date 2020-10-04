package java_1004;

import java.util.Arrays;

public class PracticeArray {
    public static void main(String[] args) {
        //1,数组逆序，用的是for循环来写的，还是先写方法再调用
        int[] arr = {1,2,3,4,5,6,7,8,9};
        //这里是直接调用方法
        Reverse1(arr);
        System.out.println(Arrays.toString(arr));
        //1,数组逆序，这里是用while循环来写的，还是先写方法 然后调用。
        int[] arr1 = {23,5,6,4,4,7,8,9};
        Reverse(arr1);
        System.out.println(Arrays.toString(arr1));
        //2,给数组中的所有元素进行奇偶排序,左边是偶数，右边是奇数。先写方法再调用
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        Transform(arr2);
        System.out.println(Arrays.toString(arr2));
        //给数组中的所有元素进行奇偶排序，左边是奇数，右边是偶数。先写方法后调用
        int[] arr3 = {1,2,3,4,5,6,7,8,9,10};
        Transform1(arr3);
        System.out.println(Arrays.toString(arr3));
    }
    //这里是数组逆序的方法，用for循环来写的。
    public static void Reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;
        for(int i = 0; i < arr.length; i ++){
            if(left < right){
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left ++;
                right --;
            }
        }
    }
    //这里是数组逆序的方法，用while来写的
    public static void Reverse1(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left ++;
            right --;
        }
    }
    //这里是让数组内的数字按顺序排列,这里写的是交换完成后数组的左边全是偶数，右边全是奇数。
    public static void Transform(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while(left < right){//是最外边的条件，不用加=.
            //这里是为了先找左边的第一个奇数，所以模2等于0（就说明它是偶数）跳过，最后返回的就是一个奇数了
            while(left < right && arr[left] % 2 == 0){
                left ++;//就是跳过
            }
            //这里是为了找右边的第一个偶数，还是模2不等0，跳过，最后的返回值是一个偶数了
            while(left < right && arr[right] % 2 != 0){
                right --;//就是跳过
            }
            //经过上边的两个人条件的判断，已经找出了第一个奇数和偶数，下边直接交换即可。
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }
    //这里是自己实现一个数组按奇偶排序的方法，左边是奇数，右边是偶数
    public static void Transform1(int[] arr){
        int left = 0;
        int right = arr.length-1;
        //进入循环，也就是循环最开始的条件
        while(left < right){
            //底下找的是左边的第一个偶数
            while(left < right && arr[left] % 2 != 0){
                left++;//不等于0，则说明是奇数，跳过，这里就找到了第一个偶数了。
            }
            while(left < right && arr[right] % 2 ==0){//找到第一个奇数
                right--;
            }
            //上边已经找到了第一个偶数和奇数，下边进行交换
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
    }
}

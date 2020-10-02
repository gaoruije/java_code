package java_1002;

import java.util.Arrays;

public class ArrayPractice<result> {
    public static void main(String[] args) {
        //1,将数组转换为字符串,借助的是Array的类。
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {1,2,3};
        System.out.println(toString(arr1));
        //2,数组的拷贝，也就是根据现在的数组在生成一个新的数组，和原数组一样。
        //a,借助java中的方法，Arrays.copyOf(original,newLength).来实现的
        int[] arr6 = {1,2,3,4,5};
        int[] arr7 = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(arr7));
        //b,借助自己写的方法来实现数组的拷贝
        int[] arr3 = {1,2,3,45};
        int[] arr4 = copyOf(arr);
        System.out.println(Arrays.toString(arr3));
        //3,把数组中的一部分进行拷贝，借助java中本身带的方法Arrays.copyOfRange来实现
        //并且里面填的数字是前闭后开的
        int[] arr5 = Arrays.copyOfRange(arr,1,3);//
        System.out.println("The new array is:" +Arrays.toString(arr5));
    }
    //底下写的都是自己实现的方法
    //自己实现一个数组转字符串的方法
    public static String toString(int[] arr){
        String result = "[";
        for(int i = 0;i < arr.length;i++){
            result += arr[i];
            if(i < arr.length-1){
                result += ",";
            }
        }
        result += "]";
        return result;
     }
     //自己实现深拷贝的代码
    public static int[] copyOf(int[] arr){
        int[] result = new int [arr.length];
        for(int i = 0;i < arr.length;i++){
            result[i] = arr[i];
        }
        return result;
    }
}

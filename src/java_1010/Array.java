package java_1010;

import java.util.Arrays;

public class Array {
    //验证一个数组内的所有数字知否是等差数列，要是原来不是，经过排序后是等差数列也可以。
    public boolean canMerArithmeticprogression(int[] arr){
        //1,先进行排序，这样就最后能直接进行判断了,这里是按升序的方法排列的。
        for(int bound = 0; bound < arr.length-1; bound++){
            for(int cur = 0; cur < arr.length-bound-1; cur++){
                if (arr[cur] > arr[cur+1]){
                    int tmp = arr[cur];
                    arr[cur] = arr[cur+1];
                    arr[cur+1] = tmp;
                }
                }
            }
        System.out.println(Arrays.toString(arr));
        //2,这里再进行第二个模块，判断是否是等差数列，中间一项的二倍是前一项和后一项之和。
        for(int i = 1; i < arr.length-1; i++){
            if(arr[i]*2 == arr[i]+arr[i+1]){
                return true;
            }
        }
        return false;
    }
}

package java_1011;

import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(arr));
    }
}

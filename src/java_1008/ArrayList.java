package java_1008;

public class ArrayList {
    //数组逆序
    public static void reverse(int[] arr){
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
}

package Java_2021_01_15;

import java.util.Arrays;

public class MoveArrayPosition {
    //给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        MoveArray(arr,3);

    }

    public static void MoveArray(int[] arr, int k) {
        //先创建一个和原来数组长度一样长的数组
        int size = arr.length;
        int[] arr1 = new int[size];
        for (int i = 0; i < arr.length; i++) {
            //下边是要注意的，要是直接进行交换的话势必会抛出数组越界的异常，所以我们就要
            //当里边的数组的长度超过本来数组长度的时候，我们用棋其来模上它的数组的长度，就刚回到了前边了，
            arr1[(i + k) % size] = arr[i];
        }
        //最后将新数组拷贝至原数组即可。
        System.arraycopy(arr1,0,arr,0,size);
        System.out.println(Arrays.toString(arr1));
    }
}

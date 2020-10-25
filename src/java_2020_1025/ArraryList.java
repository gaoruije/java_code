package java_2020_1025;

public class ArraryList {
    //冒泡排序法，升序排列。
    public static void bubbleSort(int[] arr){
        for(int bound = 0; bound < arr.length-1; bound++){
            for(int cur = 0; cur < arr.length-bound-1; cur++){
                if(arr[cur] > arr[cur+1]){
                    int tmp = arr[cur];
                    arr[cur] = arr[cur+1];
                    arr[cur+1] = tmp;
                }
            }
        }
    }
    //数组逆序排列
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
    //二分查找法
    private static int binarySearch(int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if(toFind < arr[mid]){
                right = mid-1;
            }else if(toFind > arr[mid]){
                left = mid+1;
            }else{
                return arr[mid];
                // toFind = arr[mid];
            }
        }
        return -1;
    }
}

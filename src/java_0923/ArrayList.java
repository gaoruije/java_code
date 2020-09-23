package java_0923;

public class ArrayList {
    public static void main(String[] args) {
    }
    //冒泡排序法,按升序法排列
    public static void bubbleSort(int[] arr){
        for(int bound = 0; bound <= arr.length-1; bound++ ){
            for(int cur = 0; cur <= arr.length-bound-1; cur++){
                if(arr[cur] >= arr[cur+1]){
                    int tmp = arr[cur];
                    arr[cur] = arr[cur+1];
                    arr[cur+1] = tmp;
                }
            }
        }
    }
    //进行数组逆序
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int a = arr[left];
            arr[left] = arr[right];
            arr[right] = a;
            left++;
            right--;
        }
    }
    //二分查找法找要得到的数字
    public static int binarySearch(int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid =(left + right)/2;
            if(toFind < arr[mid]){
                right = mid-1;
            }else if(toFind > arr[mid]){
                left = mid+1;
            }else{
                return arr[mid];
            }
        }
        return -1;
    }
}

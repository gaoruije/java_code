package java_1011;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int result = BinarySearch(arr,5);
        System.out.println(result);

    }
    private static int BinarySearch(int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right)/2;
            if(toFind < arr[mid]){
                right = mid-1;
            }else if(toFind > arr[mid]){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return-1;
    }
}

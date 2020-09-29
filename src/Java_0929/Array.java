package Java_0929;

public class Array {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        //获取数组长度,直接使用arr.length 的方法来获取长度
        System.out.println(arr.length);
        //打印数组的每个元素,这样的方法叫做遍历数组。
        for(int i = 0;i < arr.length;i++ ){
            System.out.print(arr[i] +"  ");
        }
        //更加简单的遍历数组方式,for each 来实现的
        for(int x:arr){
            System.out.println(x);
        }
        //用方法的形式来打印数组的所有参数，分为两个步骤，还是先写方法再调用
        //下边已经创建好了方法，现在直接调用PrintArray方法。
        int[] arr1 = {1,2,3,4,5};
        PrintArray(arr1);
    }
    //先创建一个PrintArray方法
    public static void PrintArray(int[] arr){
        for(int x:arr){
            System.out.print(x+"  ");
        }
    }
    //用二分法查找一个数
    public static int BinarySearch(int[] arr,int toFind){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left + right)/2;
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

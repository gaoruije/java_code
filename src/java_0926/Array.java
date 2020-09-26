package java_0926;

public class Array {
    public static void main(String[] args) {
        //创建一个数组。
        //1,基本的数组创建,也是推荐写法。
        int[] arr = {1,2,3,4,5};
        //2，使用new来创建数组
        int[] arr1 = new int[]{1,2,3,4,5,6,7};
        //使用new关键字来创建数组，指定数组的基本长度
        int[] arr2 = new int[5];
        //遍历数组，打印数组内的所有值。
        //a,用for循环
        for(int i = 0;i < arr.length; i++){
            System.out.print(arr[i] +"  ");
        }
        //b,用for each来写
        for(int x: arr){
            System.out.println(x);
        }
        System.out.println(arr[3]);
        System.out.println(arr.length);
    }
    //这里写的是一个遍历数组的方法
    public static  void printArr(int[] arr){
        for(int x:arr){
            System.out.println(x);
        }
    }
}

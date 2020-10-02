package java_1002;

public class Learn {
    public static void main(String[] args) {
        //借助方法实现输出数组的原数组的二倍，调用的是TransForm方法
        int[] arr = {1,2,3,4};
        TransForm(arr);
        for(int i = 0;i <arr.length;i++){
            System.out.print(arr[i] + "  ");
        }
        //为了换行，更清晰
        System.out.println();
        //第二种方法的调用，调用的是Transform1方法。
        int[] a = {1,2,3};
        int[] res = TransForm1(a);
        TransForm1(a);
        for(int i = 0;i < a.length;i++){
            System.out.print(res[i] +"  ");
        }
    }
    //这里写的是一个实现二倍数组输出的一个方法，记为TransForm
    public static void TransForm(int[] arr1){
        for(int a = 0;a < arr1.length;a++){
            arr1[a] *= 2;
        }
    }
    //可以将数组的大小在方法中设置出来,记为TransForm1。
    public static int[] TransForm1(int[] arr2){
        int[] result = new int[arr2.length];//这里创建了新的数组。
        for(int i = 0;i < arr2.length;i++){
            result [i] = arr2[i]*2;
        }
        return result;
  }
}

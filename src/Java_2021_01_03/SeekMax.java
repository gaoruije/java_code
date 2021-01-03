package Java_2021_01_03;

public class SeekMax {
    public static void main(String[] args) {
        //创建方法求两个数的最大值max2，随后再写一个求3个数的最大值的函数max3。
        //​ 要求：在max3这个函数中，调用max2函数，来实现3个数的最大值计算
        System.out.println( Max (3,10));
        System.out.println("最大值是：" + ThreeMax(2,98,6));
    }

    //1，三个数比较的方法。
    public static int ThreeMax(int x, int y, int z) {
        int m = Max(x,y);
        int n = Max(x,z);
        int result = Max(m,n);
        return result;
    }

    //2,两个数比较的方法
    public static int Max(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }
}

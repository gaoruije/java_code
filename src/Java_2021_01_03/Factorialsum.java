package Java_2021_01_03;

public class Factorialsum {
    public static void main(String[] args) {
        //题目要求：求1！+2！+3！+4！+........+n!的和
        //1，先直接进行打印，调用函数
        //System.out.println(FatSum(5));
        //2，题目要求：求n的阶乘
        System.out.println(Fat1(5));
    }

    private static int Fat1(int number) {
        int result = 1;
        for (int i = 1; i <= number; i++){
            result *= i;
        }
        return result;
    }

    //2,只管求和,里边嵌套求阶乘的方法
    public static int FatSum(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum += Fat(i);//给sum加上阶乘的结果。
        }
       return sum;
    }

    //3,只管求阶乘即可。
    private static int Fat(int i) {
        int result = 1;
        for (int j = 1; j <= i; j++) {
            result *= j;
        }
        return result;
    }
}

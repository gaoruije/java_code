package Java_2021_01_03;

public class SumOverload {
    //题目要求：在同一个类中,分别定义求两个整数的方法 和 三个小数之和的方法。 并执行代码，求出结果
    public static void main(String[] args) {
        Sum1(2,5);
        Sum1(2.22,2.22,2.22);
    }

    public static void Sum1(double v, double v1, double v2) {
        double result = v + v1 + v2;
        System.out.println(result);
    }

    public static void Sum1(int i, int i1) {
        int result = i + i1;
        System.out.println(result);
    }
}

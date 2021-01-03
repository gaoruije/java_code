package Java_2021_01_03;

public class FindFib {
    //题目要求：求斐波那契数列的第n项。(迭代实现)，迭代实现就是不使用递归来实现
    //清楚斐波那契数列的构成：1,1,2,3,5,8.......
    public static void main(String[] args) {
        System.out.println(Fib(5));
    }

    //斐波那契数列的第N项的具体实现。
    public static int Fib(int number) {
        int first = 1;
        int second = 1;
        int result = 1;
        if (number == 1 || number == 2) {
            return result;
        }
        //i 由2开始的因为前边的1,2都是确定的，由第二项后边开始变换i
        for (int i = 2; i < number; i++){
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }
}

package Java_2021_01_03;

public class PrintEveryone {
    public static void main(String[] args) {
        //题目要求：输出一个数字的每一位。
        Printeveryone(123);
    }

    public static void Printeveryone(int number) {
        //递归实现，出口条件 i < 10时
        if (number > 9) {
           Printeveryone(number / 10);
        }
        System.out.print(number % 10 + " ");
    }
}

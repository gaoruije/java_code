package java_2020_12_29;

import java.util.Scanner;

public class PrintAge {
    public static void main(String[] args) {
        //题目要求：根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)
        Printage();
    }

    public static void Printage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您要写入的年龄：");
        int number = scanner.nextInt();
        Judgeage(number);
    }

    public static void Judgeage(int number) {
        if (number <= 18) {
            System.out.println("是少年");
        } else if (number <= 28){
            System.out.println("是青年");
        } else if (number <= 55) {
            System.out.println("是中年");
        } else {
            System.out.println("是老年");
        }
    }
}

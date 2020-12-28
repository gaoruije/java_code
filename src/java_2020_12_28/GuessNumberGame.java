package java_2020_12_28;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        while (true) {//创建一个死循环，用户不止玩一次
            int choice = menu();//创建一个菜单的方法，用choice来进行接收
            if (choice == 1) {
                Game();//要是用户选择了1，则证明进行游戏
            } else if (choice == 0) {//用户选择了0，就说明用户想退出了
                System.out.println("Goodbye！！！");
            } else {//输入其他的数字，提示用输入有误
                System.out.println("您的输入有误，请重新输入！！！");
            }
         }
    }

    //1，这里直接创建了一个Game的方法
    public static void Game() {
        //首先用户不止输入一次就能猜对，先来一个死循环
        //1,先生成一个随机数字[1,100]，借助Random来进行。
        Random random = new Random();
        int toGuess = random.nextInt(100) + 1;
        //2，需要用户从键盘上进行输入，所以肯定用Scanner,方在循环的外边可以提高效率
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //这里先提示一下用户，一定记着提示在里边，因为用户要循环的输入。
            System.out.println("请您输入您所猜的数字：");
            int num = scanner.nextInt();//用一个num来进行接收读取到的数值。
            if (num < toGuess ) {
                System.out.println("猜小了！！！");
            } else if (num > toGuess) {
                System.out.println("猜大了！！！");
            } else {
                System.out.println("恭喜您，猜对了！！！");
                break;
            }
        }
    }
    //2，创建菜单方法
    public static int menu() {
        //用户要从键盘上进行读取数字，要要到Scanner来进行。
        Scanner scanner = new Scanner(System.in);
        System.out.println("################################");
        System.out.println("##  1,开始游戏    0，退出游戏  ##");
        System.out.println("################################");
        System.out.println("请输入您的选择：");
        int choice = scanner.nextInt();
        return choice;//进行值得返回。
    }
}

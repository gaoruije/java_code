package java_2020_12_27;

import java.util.Random;
import java.util.Scanner;

public class Guessthenumber {
    //电脑回随机生成一个随机数[1,100]，然后让用户来进行猜数字，直到猜对为止。
    public static void main(String[] args) {

        //1，先随机生成一个随机数
        Random random = new Random();
        int toGuess = random.nextInt(100) + 1;//边界条件是前开后闭，包含0不包含后边的数字
        //2，让用户进行猜数字
        Scanner scanner = new Scanner(System.in);//连续从键盘上进行读取
        while (true) {
            System.out.println("请输入你所猜的数字：");
            int num = scanner.nextInt();
            if (toGuess < num) {
                System.out.println("猜高了！！！");
            } else if (toGuess > num) {
                System.out.println("猜低了！！！");
            } else {
                System.out.println("恭喜你，猜对了！！！");
                break;
            }
        }
    }
}


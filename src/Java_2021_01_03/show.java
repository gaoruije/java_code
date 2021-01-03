package Java_2021_01_03;

import java.util.Scanner;

public class show {
    public static void main(String[] args) {
        //打印x型图案
        //1，先写一个show函数，表示输出X图案。
        Show();
    }

    //2,打印行数，这里要读入数据，只管输出多少行。
    public static void Show() {
        Scanner scanner = new Scanner (System.in);
        //提示一下让用户输入他想打印的行数。
        System.out.println("请输入您想打印的行数：");
        int result = scanner.nextInt();
        for (int i = 1; i <= result; i++) {
            PrintRow(i,result);
            //每循环完一次后要进行换行。
            System.out.println();
        }
    }

    //3，打印每一行的方法，传入两个参数，因为这里要穿那个读入的行数。
    public static void PrintRow(int i,int result) {
        for (int j = 1; j <= result; j++) {
            //好好分析一下图案的规律
            if(i == j || i == (result - j + 1)) {
                System.out.print('*');
            } else {
                System.out.print(' ');
            }
        }
    }
}

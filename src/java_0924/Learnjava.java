package java_0924;

import java.util.Random;
import java.util.Scanner;

public class Learnjava {
    public static void main(String[] args) {
        //在键盘上输入东西
        //a,先生成一个随机整数（1~100），用random 方法来生成。
//        Random random = new Random();
//        int toGuess = random.nextInt(100)+1;
//        //让用户在键盘上输入一个整数，借助Scanner方法来实现。
//        Scanner scanner = new Scanner(System.in);
//        while(true){
//            System.out.println("请您输入要菜的数字（1~100）：");
//            int num = scanner.nextInt();
//            if(num < toGuess){
//                System.out.println("您输入的数字小了");
//            }else if(num > toGuess){
//                System.out.println("您输入的数字大了");
//            }else{
//                System.out.println("您猜对了");
//                //猜对了之后记得要停止
//                break;
//            }
        //这块直接调用add方法来实现相加
        int ret = add(10,20);
        System.out.println("ret =" +ret);
        //可以多次进行调用
        int ret1 = add(67,78);
        int ret2 = add(78,78);
        int ret3 = add(ret1,ret2);
        System.out.println("最后结果是：" + ret3);
        //交换两个变量的问题，理解形参和实参
        int a = 1;
        int b = 2;
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("a = " + a + "b =" + b);
        //用调用方法来实现交换两个整数，还是先要在底下写一个交换方法 swap。
        //调用底下的swap方法
        int[] arr ={10,20};
        swap(arr);
        System.out.println("a = " + arr[0] + "     "+"b =" + arr[1]);
    }
    //这里写了一个add方法，为了一会直接调用。
    public static int add(int x, int y){
        int ret = x + y;
        //一定要有返回值
        return ret;
    }
    //创建一个swap方法，要进行交换的话就只能，定义一个数组
    public static void swap(int[] arr){
        int tmp = arr[0] ;
        arr[0] = arr[1];
        arr[1] = tmp;
    }

}



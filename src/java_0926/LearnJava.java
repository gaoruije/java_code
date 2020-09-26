package java_0926;

import java.util.Random;
import java.util.Scanner;

public class LearnJava {
    public static void main(String[] args) {
        //用递归来实现以下代码。
        //1,用递归来实现求阶乘
        //下边已经写了，递归方法，现在直接调用
        //int tmp = swap(3);
        //System.out.println(tmp);
        //随机生成一个随机数的代码
        //Random random = new Random();//这里是创建了一个Random 对象
        //int ret = random.nextInt(100);//这里是设定随机数的个数，1~99.注意前开后闭。
        //System.out.println(ret);
        //2,打印数据的每一位，直接调用下边的print方法
        //System.out.println("请输入数字：");
        //这个是调用输出的方法
        //print(new Scanner(System.in).nextInt());
        //3,用递归来计算1~10的和
        int ret2 = sum(10);
        System.out.println(ret2);
        //4,写一个方法来实现输入1729，最终输出1+7+2+9
        int ret3 = sum1(1729);
        System.out.println(ret3);
        //求斐波那契数的第n项
        int ret4 = fit(40);
        System.out.println(ret4);
        int ret5 = fit2(45);
        System.out.println(ret5);
    }
    //这里是写的一个递归的方法，为了让上边直接调用
    //public static int swap(int n) {
       //if (n == 1) {
            //return 1;
       // }
        //return n * swap(n - 1);
   // }

    //public static void print(int m) {
        //if (m > 9) {//里面的循环还是会慢慢靠近if中的条件的，当不满足条件的时候，会一直循环下去。
            //print(m / 10);//"/"表示的除的意思，“%”表示的是模的意思。
        //}
        //System.out.print(m % 10 + "   ");//这个最后才会打印的。
    //}
    //递归求和
    public static int sum(int m){
        if(m == 1){
            return 1;
        }
        return m += sum(m-1);
    }

    //递归求输入数字的各位和
    public static int sum1(int n){
        if(n < 10){
            return n;
        }
        return n % 10 + sum1(n / 10);
    }
    //用递归方法写斐波那契数列
    public static int fit(int n){
        if(n == 1 || n == 2){
            return 1;
        }
          return fit(n - 1) + fit(n -2);
    }
    //用一般循环写斐波那契数列
    public static int fit2(int m){
        if(m == 1 || m == 2){
            return 1;
        }
        //使用非递归方法，也就是循环的方法来实现。
        int last1 = 1;
        int last2 = 1;
        int cur = 0;
        for(int i = 3;i <= m; i++){
            cur = last2 + last1;
            last2 = last1;
            last1 = cur;
        }
        return cur;
    }


}

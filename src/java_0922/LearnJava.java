package java_0922;

public class LearnJava {
    public static void main(String[] args) {
        //循环结构
        //1，while循环，从  0到5进行打印
        int num = 0;
        while (num <= 5) {
            System.out.print(num + " ");
            num++;
        }
        //2,用while循环计算1到100的和
        int a = 1;
        int sum = 0;
        while (a < 101) {
            sum += a;//表示sum = sum+a.
            a++;
        }
        System.out.print("sum = " + sum + " ");
        //3，用while来计算5 的阶乘
        int b = 1;
        int c = 1;
        while (b <= 5) {
            c *= b;//表示c = c*b.
            b++;
        }
        System.out.println("c = " + c + " ");
        //接的是求阶乘和，调用factor方法来求和
        int d = 1;
        int sum1 = 0;
        while(d <= 5){
            sum1 += factor(d);
            d++;
        }
        System.out.println("sum1 = "+ sum1);
        //break在while中的用法
        //找出1~100中的第一个能被5整除的数字，借用break来实现。
        int h = 1;
        while(h <= 100){
            if(h%5 == 0){
                break;
            }
            h++;
        }
        System.out.println(h);
        //找出483~747内所有能被13整除的所有数字
        int j = 483;
        while(j <= 747){
            if(j % 13 == 0){
                System.out.println(j + " ");
            }
            j++;
        }
        //找出1~100中的所有能被7整除的所有数字。
        int k = 1;
        while(k <= 100){
            if(k % 7 != 0){
                k++;
                continue;
            }
            System.out.println(k+"   ");
            k++;
        }
    }
    //计算1~5的阶乘的和
    //a,首先创建一个能写阶乘的方法，到时用这个方法求和
    public static int factor(int n){//这个n是从1开始的，每出一次方法n的值加一。
        int b = 1;
        int c = 1;
        while (b <= n) {
            c *= b;//表示c = c*b.
            b++;
        }
        return c;
    }
}
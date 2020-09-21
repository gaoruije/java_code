package java_0921;

import java.util.Scanner;

public class LearnJava {
    public static void main(String[] args) {
        //前置++，返回的是自增之后的值
        int a = 10;
        int b = ++a;//b的结果是11
        //后置++，返回值是自增之前的值
        int c = 10;
        int d = c++;//c的结果是10
        //关于java中的关系运算符，返回值只可能是Boolean型。
        int e = 10;
        int f = 17;
        int g = 20;
       // System.out.println(e < f < g);//比较后的类型不一样，所以会报错。
        System.out.println(e < f && f < g);//这样就可以了，表示的含义是e<f并且f<g.
        int h = 10;
        int i = 89;
        System.out.println(h ^ i);
        //按位取反
        int j = 4;
        System.out.println(~ j);
        int k = 1;
        int l = 2;
        int max = k > l ? 4:5;
        System.out.println(max);
        //分支语句
        //1,if else语句。
        int n = 10;
        int m = 8;
        if(n < m){
            System.out.println("n < m");
        } else {
            System.out.println("haha");
        }
        //用if else可以来写多分支
        int p = 999;
        if(p < 90){
            System.out.println("p 比较小");
        }else if(p == 90){
            System.out.println("p 就是90");
        }else if(p > 90 && p< 100){
            System.out.println("p 介于90~100之间");
        }else{
            System.out.println("哈哈");
        }
        //判断奇偶数
        int t = 3;
        if(t/2 == 0){
            System.out.println("这个数是偶数");
        }else {
            System.out.println("这个数是奇数");
        }
        //如何在java中实现手动输入东西，然后判断再打印
        //1,先手动创建一个 Scanner 对象.scanner 是类型，new scanner 是所创建的对象。
        //Scanner scanner = new Scanner(System.in);//这个本来要手动导入 import 的，idea中直接补全了。
        //2，在键盘上读入整数
        //int num2 =  scanner.nextInt();
        //判断正负数字
        int num3 = -1;
        if(num3 < 0){
            System.out.println("这个数字是负数");
        }else if(num3 > 0){
            System.out.println("这个数字是正数");
        }else{
            System.out.println("这个数字是0");
        }
        //1，判断是否是普通闰年（能被4整除并且不能被100整除）
        int year = 3200;
        if(year % 4 == 0 && year % 100 != 0){
            System.out.println("这个年份是普通闰年");
        }else {
            System.out.println("这个年份不是普通闰年");
        }
        //2，判断是否为世纪闰年（能被400整除的就是世纪闰年）
        int year1 = 3200;
        if(year1 % 400 == 0){
            System.out.println("这个年份是世纪闰年");
        }else {
            System.out.println("但是不是世纪闰年");
        }
        //2,switch语句


    }
}

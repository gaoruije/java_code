package java_0923;

import java.util.Scanner;

public class StudyJava {
    public static void main(String[] args) {
        //用for循环来实现打印1~10的值。
        for(int a = 1; a <= 10; a++){
            System.out.print(a +"  ");
        }
        //用for循环来计算1~100的值
        int sum = 0;
        for(int b = 1;b <= 100;b++){
            sum += b;
        }
        System.out.println(sum +"  ");
        //用for循环计算5的阶乘
        int ret = 1;
        for(int c = 1;c <= 5; c++){
            ret *= c;
        }
        System.out.println(ret);
        //用for循环来实现1！加到5！的和。
        int num = 0;
        for(int f = 1;f <= 5;f++){
            num += factor(f);
        }
        System.out.println(num);
        //输入输出代码
        System.out.println("haha");//输出带换行。
        System.out.println("hehe");//输出带换行。
        //在键盘上输出，用Scanner来读取字符串、整数、浮点数。
        //1，创建Scanner对象
        Scanner scanner = new Scanner(System.in);//System.in对应标准库的读入。
        //核心用 .next 来读取数据，不同的类型next后跟的类型不一样。
        System.out.println("请输入你的姓名：");
        String name = scanner.next();
        System.out.println("请输入你的年龄：");
        int age = scanner.nextInt();
        System.out.println("请输入你的绩点");
        double score = scanner.nextDouble();
        System.out.println("您的基本信息如下：");
        System.out.print("姓名： "+ name +"  ");
        System.out.print("年龄： "+ age +"  ");
        System.out.print("绩点:  "+ score +"  ");
        //让用户输入若干个数字，来计算这些整数的和。
        System.out.println();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("请输入若干个整数");
        int sum1 = 0;
        //这里用到的.hasnext()方法，就是判断是否有下一个元素。
        while(scanner1.hasNext()){
            int num1 = scanner1.nextInt();
            sum1 += num1;
        }
        System.out.println("您所输入的所有数字之和是：" + sum1);
    }
    //这里写的是factor方法为了，一会调用。
    public static int factor(int n){
        int d = 1;
        for(int e = 1; e <=n; e++){//切记e的值一定是 <= n.
            d *= e;
        }
        return d;
    }
}

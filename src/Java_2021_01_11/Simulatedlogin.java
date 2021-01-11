package Java_2021_01_11;

import java.util.Scanner;

//模拟实现用户三次登录
public class Simulatedlogin {
    public static void main(String[] args) {
        Simulatedlogin();
    }

    public static void Simulatedlogin() {
        //先设置一个自己的密码
        String password = "gaoruijie";
        //设置让用户能读入自己写的密码
        int i = 0;//将i放在外边，为的是下边在用户输入密码三次错误的情况下能提示用户不能登录了。
        //将读入数据放在外边，可以降低时间复杂度
        Scanner scanner = new Scanner(System.in);
        for (; i < 3; i++) {
            System.out.println("请您输入密码:");
            String input = scanner.next();
            //用户输入完密码后，接下来就是比较两个字符串是否相等，用到的方法是.equals，返回值是true或者false。
            //要是相等，就直接显示登录成功
            if (input.equals(password)) {
                System.out.println("登录成功");
                //登录成功后不用继续循环，直接break退出
                break;
            } else {//提示用户密码输入有误，密码有误时，还有机会再输入，所以还在循环里边。
                System.out.print("密码输入有误！");
            }
        }
        //下边我们通过i的值来判断上边循环结束的条件
        //1，是上边碰到了break，直接跳出循环了；2，是走完上边的循环了，还是没有登录成功。
        if (i == 3) {//说明了用户已经输入了三次了，提示用户不能在输入了，就是不能在进入循环了。
            System.out.println("您已输入密码三次，密码错误自动退出！");
        }
    }
}

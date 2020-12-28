package java_2020_12_28;

import java.util.Scanner;

public class SimulatedLogin {
    public static void main(String[] args) {
        //1,直接进行调用登录的方法，后边具体研究方法的实现过程
         Login();
    }
    public static void Login() {
        //a,先设置一个本来的密码
        String Password = "Gaoruijie";
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        //b,进行判断输入的密码是否准确，只要求最多输入3次，所以用for循环
        for (; i < 3; i++) {
            System.out.println("请输入您的密码：");
            String input = scanner.next();
            if (input.equals(Password)) {
                System.out.println("登录成功！！！");
                break;//一旦登录成功后，程序直接跳出了
            } else {
                System.out.println("登录失败！！！");
            }
        }
        //c,判断i的数字是几，要是3，则说明用户已经登录了3次了，提示用户一下。
        if (i == 3) {
            System.out.println("您已输入3次，密码错误自动退出！！！");
        }
    }
}

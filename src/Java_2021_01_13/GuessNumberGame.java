package Java_2021_01_13;

import java.util.Random;
import java.util.Scanner;

public class GuessNumberGame {
    //猜数字游戏的编写，包含登录的界面。
    public static void main(String[] args) {
        //1，编写登录界面，用户有三次机会输入密码，要是输入三次错误就直接退出，要是输入准确就能进行游戏，
        //a，先设置一个密码，用来进行登录
        String password = "gaoruijie";
        //因为要输入3次，我们来一个for循环，来控制循环的次数
        int i = 0;
        for (; i < 3; i ++) {
            //提示用户输入密码。
            Scanner scanner = new Scanner(System.in);
            System.out.println("请您输入登录密码：");
            //将用户输入的密码用来保存。
            String input = scanner.next();
            //下边就是进行比较用户输入的密码是否与原来设置的密码相同。
           if (password.equals(input)) {//表示相同，提示用户登录成功
               System.out.println("登录成功，请进行选择是否要进行猜数字游戏。");
               break;
           } else {
               System.out.println("密码错误！");
           }
        }
        //判断一下i的值，看i的值是多少，提示用户是否登录成功。
        if (i >= 3) {
            System.out.println("您已输入密码三次，密码错误，登录失败！");
        }
        //2，上边已经做好了用户的登录的模块，下边是猜数字的模块。
        while (true) {
            int choice = Memu();//因为这里的菜单有一个返回值，所以下边的方法用的是int型的。
            //要是choice的值是1，则表示用户哟啊进行游戏。
            if (choice == 1) {
                Game();
            } else if (choice == 2) {//用2来表示用户不想进行游戏了。
                System.out.println("GoodBye!");
            } else {//要是输入其他的数字，提示用户输入有误
                System.out.println("输入有误，请重新输入数字1或者2");
            }
        }
    }

    public static void Game() {
        //先生成一个1~100的随机数，用方法random.
        Random random = new Random();
        //里边填的参数是0~那个数字减去1的数字，所以我们在加上1就好了。
        int ToGuess = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请您输入您所想的数字（1~100）：");
            int MyNumber = scanner.nextInt();
            //这里要将你所猜的数字写在前边，要是写在后边的话，程序不能正常进行了。
            if (MyNumber > ToGuess) {
                System.out.println("猜大了");
            } else if (MyNumber < ToGuess) {
                System.out.println("猜小了");
            } else {
                System.out.println("恭喜您猜对了！");
                //退出循环。
                break;
            }
        }
    }

    public static int Memu() {
        //创建一个能存数字的对象,用choice来进行接收。
        Scanner scanner = new Scanner(System.in);
        System.out.println("##################################");
        System.out.println("####  1,开始游戏   2,退出游戏  ####");
        System.out.println("##################################");
        System.out.println("请输入您的选择：");
        int choice = scanner.nextInt();
        return choice;
    }
}

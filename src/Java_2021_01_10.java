import java.util.Scanner;

public class Java_2021_01_10 {
    public static void main(String[] args) {
        //1，输入一个年龄数据，按照要求输出年龄段
        //PrintAge();
        //2，判定一个数字是否是素数,是素数返回true，否则返回false,要注意一下2是素数。
        //System.out.println(JudgePrime(2));
        //3,打印1~100之间所有的素数。
        //PrintAllPrimes(1,100);
        //4,输出1000~2000之间的所有的闰年。
        //PrintAllLeapYears(1000,2000);
        //5,输出乘法口诀表
        //PrintMultiplicationTable();
        //6，求两个正整数的最大公约数
        //System.out.println(GCD(3,7));
        //7，计算1 - 1/2 + 1/3 - 1/4 .......-1/n（n是偶数）
        //System.out.println(RegularSum(1,100));
        //8,数一下1~100中有多少个9.
        //SeekNumberOfNine(0,109);
        //9,输出0~999之间的所有的水仙花
        //PrintAllDaffodils(0,999);
        //10,求一个输入的十进制中转换为二进制后里边有多少个1
        //SeeknumberofOne(15);
        //11,输出一个整数的每一位
        //PrintDigit(12345);
    }

    public static void PrintDigit(int i) {
        //递归的出口
        if (i > 9) {
            PrintDigit(i / 10);
        }
        System.out.print(i % 10 + " ");
    }

    public static void SeeknumberofOne(int number) {
        int count = 0;
        for (int i = number; i > 0; i >>= 1) {
          if (IsOne(i)) {
              count ++;
          }
      }
        System.out.println("您输入的数字转换为二进制后1的个数有：" + count + "个。");
    }

    public static boolean IsOne(int i) {
        if ((i & 1) == 1) {
            return true;
        } else {
            return false;
        }
    }


    public static void PrintAllDaffodils(int begin, int end) {
        for (int i = begin; i <= end; i++) {
            if (IslDaffodil(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean IslDaffodil(int i) {
        //提取个位
        int gewei = i % 10;
        //提取十位
        int shiwei = i / 10;
         shiwei = shiwei % 10;
         //提取百位
        int baiwei = i / 100;
        baiwei = baiwei % 10;
        //来一个求立方的方法
        if (Cue(gewei) + Cue(baiwei) + Cue(shiwei) == i) {
            return true;
        } else {
            return false;
        }
    }

    public static int Cue(int i) {
        return i * i * i;
    }

    public static void SeekNumberOfNine(int begin, int end) {
        int count = 0;
        for (int i = begin; i <= end; i++) {
            //先判断个位是不是含有9
            if (i % 10 == 9) {
                count ++;
            }
            //再判断十位是否含有9
            if (i / 10 == 9) {
                count ++;
            }
            //再判断百位有没有9.
            if (i / 100 == 9) {
                count ++;
            }
        }
        System.out.println("9的个数有： " + count + "个。");
    }


    public static double RegularSum(int begin,int end) {
        double sum = 0.0;
        //这里我们发现他是有规律的，我们采取两个一求和的方式。
        for (int i = begin; i < end; i += 2) {
            sum += TwoSum(i);
        }
        return sum;
    }

    public static double TwoSum(int i) {
        //这里要记住来个强制类型转换
        return (double)(1.0 / i) - (double)(1.0 / (i + 1));
    }

    public static int GCD(int a,int b) {
        for (int result = Min(a,b); result > 1; result--) {
            if (a % result == 0 && b % result == 0) {
                return result;
            }
        }
        //上边的循环是找出过两个互质的情况，要是还是没有找见，及说明他们的最大公约数是1.
        return 1;
    }

    public static int Min(int a,int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    public static void PrintMultiplicationTable() {
        //1,还是关心行数，具体里边再关心每一行里边的内容。
        for (int row = 1; row <= 9; row++) {
            //打印每一行里边的内容
            PrintColumn(row);
        }
    }

    public static void PrintColumn(int row) {
        for (int column = 1; column <= row; column++) {
            //标准输出。
            System.out.printf("%dX%d=%-2d ",column,row,row*column);
        }
        //每次结束后，来个换行
        System.out.println();
    }



    public static void PrintAllLeapYears (int begin,int end) {
        for (int year = begin; year <= end; year++) {
            //普通闰年
            if (year % 100 != 0 && year % 4 == 0) {
                System.out.println(year);
            }
            //世纪闰年
            if (year % 400 == 0) {
                System.out.println(year);
            }
        }
    }

    public static void PrintAllPrimes(int begin,int end) {
        int count = 0;
        //从begin到end依次判断是否是素数，要是是素数，就进行打印，count++，我们用个count来统计一下有，多个素数。
        for (int i = begin; i <= end; i++) {
            //进行判断，调用前边写的那个判断素数的方法。
            if (JudgePrime(i)) {
                System.out.print(i + "  ");
                count ++;
            }
        }
        //打印一下有多少个素数。
        System.out.println();
        System.out.println(count);
    }
    public static boolean JudgePrime(int number) {
        if (number == 1 ) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            //要是有一个能被整除，就说明不是素数，返回false
            if (number % i == 0) {
                return false;
            }
        }
        //等待循环结束后，就说明它是素数了
        return true;
    }

    public static void PrintAge() {
        System.out.println("请您输入年龄：");
        //创建的一个对象，用来存用户输入的数字。
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if (age <= 18) {
            System.out.println("是少年");
        } else if (age <= 28) {
            System.out.println("是青年");
        } else if (age <= 55) {
            System.out.println("是中年");
        } else {
            System.out.println("是老年");
        }
    }
}

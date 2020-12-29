package java_2020_12_29;

public class JudgePrime {
    public static void main(String[] args) {
        //题目要求：判断一个数字是否是素数。
        IsPrime(5);
    }
    //负责告诉用户是否是素数。
    public static void IsPrime (int number) {
            if (isPrime(number)) {
                System.out.println("是素数");
            } else {
                System.out.println("不是素数");
            }
    }
    public static boolean isPrime (int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        //等所有的循环结束后，就说明它一定是素数了。
        return true;
    }
}

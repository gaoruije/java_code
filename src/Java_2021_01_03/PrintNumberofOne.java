package Java_2021_01_03;


public class PrintNumberofOne {
    public static void main(String[] args) {
        //题目要求：求一个整数，在内存当中存储时，二进制1的个数。
        //首先明白输入的数字在内存中是以二进制补码的方式存储的，
        // 要想获取二进制中1的个数，只需要用十进制数字和0异或即可
        //1，打印1的个数。
        System.out.println("您所输入的数字中1的个数有" + NumberOfone(11) + "个。");
    }

    //2,统计1的个数。
    public static int NumberOfone(int number) {
        int count = 0;
        //当number右移不是0的时候每次循环一直继续。
        for (int i = number; i > 0; i >>= 1) {//每进行完一次，都得右移一位。
            if (Isone(i)) {
                count ++;
            }
        }
        return count;
    }

    //3,判断是不是1.
    public static boolean Isone(int number) {
        //将一个数字和1进行单位与操作，可得到最后一位是否是1.
        if ((number & 1) == 1) {
            return true;
        } else {
            return false;
        }
    }
}
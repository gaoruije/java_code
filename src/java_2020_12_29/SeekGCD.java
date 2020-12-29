package java_2020_12_29;

public class SeekGCD {
    public static void main (String[] args) {
        //题目要求：求两个数的最大公约数
        // 先直接调用求最大公约数方法,用result来接收一下。
       int result = seekGCD(3,5);
        System.out.println(result);
    }

     //这里是求公约数的方法。
    public static int seekGCD (int small,int large) {
        int min = min(small,large);
        for (int i = min; i >= 1; i--) {
            //这里又是一个判断公约数
            if(small % i == 0 && large % i == 0) {//有最大公共约数
                return i;
            }
        }
        //要是走完上边还是没有结束，这里就直接返回两个数的最小的公共约数1
        return 1;
    }

    //求最小值的方法
    public static int min (int small,int large) {
        if (small < large) {
            return small;
        } else {
            return large;
        }
    }
}

package java_2020_12_29;


public class RegularSUM {
    public static void main(String[] args) {
        //题目要求：求1 - 1/2 + 1/3 - 1/4 ...... - 1/n（n一定是偶数）
        double result = Sum(1,4);
        System.out.println(result);
    }
    //这个是一个大的求和，里边再拆分为小的求和，两项两项进行考虑，这样可以忽略胜负号
    public static double Sum(int begin,int end) {
        double result = 0.0;
        for (int i = begin; i < end; i +=2) {
            result += Sum(i);
        }
        return result;
    }
    public static double Sum (int i) {
        //在求小数的时候一定要注意,用1.0哦
        return 1.0 / i - 1.0 / (i + 1);
    }
}

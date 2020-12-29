package java_2020_12_29;

public class SeekNumberNine {
    public static void main(String[] args) {
        //题目要求：求1~100之间9的个数有多少个。
        System.out.println("您输入的范围内9的个数有：" + SeekNumber9(1,100) + "个");
    }
    public static int SeekNumber9(int begin,int end) {
        int count = 0;//设置一个count计数器，用来统计9的个数。
        for (int i = begin; i <= end; i++) {
           count += Contain9(i);
        }
        return count;
    }
    //判断有多少个9的方法，因为要判断的位数不止一个，所以要用int来接收，count不止是1个。
    public static int Contain9 (int i) {
        int count = 0;
        int gewei = i % 10;
        if (gewei == 9) {
            count++;
        }
        int shiwei  = i / 10;
        if (shiwei == 9) {
            count++;
        }
        return count;
    }
}

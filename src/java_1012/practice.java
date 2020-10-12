package java_1012;

public class practice {
    public static void main(String[] args) {
        //1,判断一个数是否是奇数
        int tmp = 4;
        if(tmp % 2 == 0){
            System.out.println("4"+"这个数字不是奇数");
        }else{
            System.out.println("4"+"这个数字是奇数");
        }
        //2,输出1~100之间的所有的奇数
        for(int i = 1; i <= 100; i ++){
            if(i % 2 != 0){
                System.out.print(i+"  ");
                System.out.println();
            }
        }
        //3,计算5的阶乘
        int sum = 1;
        for(int i = 1; i <= 5; i++){
            sum *= i;
        }
        System.out.println("阶乘是："+sum);
    }
}

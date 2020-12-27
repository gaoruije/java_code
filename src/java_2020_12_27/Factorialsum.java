package java_2020_12_27;
public class Factorialsum {
    public static void main(String[] args) {
        //1，不使用方法来实现求5的阶乘和。
        //两层循环，外层控制求和内层控制求阶乘
        int sum = 0;
        for(int i = 1; i <= 5; i++){
            int temp = 1;
            for(int j = 1; j <= i; j++){
                temp *= j;
            }
            sum += temp;
        }
        System.out.println(sum);
        //2，用方法来实现,main 函数中进行调用，底下来进行实现。
        System.out.println(Factorialsum());
    }
    //求和的方法，里边包含调用求阶乘的方法
    public static int Factorialsum(){
        //这里只管求和，下边在进行求阶乘。
        int result = 0;
        for(int num = 1; num <= 5; num ++) {
           result += factorial(num);//需要啥就写啥方法，啥时用啥时候进行调用即可。
        }
        return result;
    }
    //求阶乘的方法
    public static int factorial(int num){
        int temp = 1;
        for(int i = 1; i<= num; i++){
            temp *= i;
        }
        return temp;
    }
}

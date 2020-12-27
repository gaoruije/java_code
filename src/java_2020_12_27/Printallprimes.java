package java_2020_12_27;

public class Printallprimes {
    public static void main(String[] args) {
        //这里直接进行调用函数，底下写的是实现的方法
        Printallprimes(1,100);
    }
    //1，次方法只管打印素数
    public static void Printallprimes(int begin,int end){
        int count = 0;
        for(int i = begin; i <= end; i++){
            if(Isprime(i)) {//括号里边是true或者false
                count++;
                System.out.print(i + " ");//调用判断素数的方法
            }
        }
        System.out.println();
        System.out.println("所有的素数的个数是："+ count + "个");
    }
    //此方法只管判断素数,注意用到是布尔类型，这样才能出现打印或者不打印两种结果
   public static boolean Isprime(int num){
        //先判断一下1是否是素数。
        if(num == 1){
            return false;//单独判断1不是素数
        }
        for(int i = 2; i < num; i++){
            if(num % i == 0){//说明不是素数
                return false;
            }
        }
        return true;//等循环结束后，就说明它一定是素数了。
   }
}

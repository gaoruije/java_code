package java_0927;

public class Learn {
    public static void main(String[] args) {
        //打印1~10的数字
        int i = 0;//初始条件的设定
        while(i <= 10){//while 的条件设置
            System.out.print(i +"  ");//具体需要的操作
            i++;//条件更新
        }
        //输出一个while和if结合的代码
        int a = 1;
        while(a <= 10){
            if(a <= 5){
                System.out.println("你还不行，还得好好练习");
            }
        }
        System.out.println("你还可以，得继续加油哟");
        
    }
}

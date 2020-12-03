package java_2020_12_03;

public class test {
    public static void main(String[] args) {
//        System.out.print("Hello world!\n");
//        int num = 10;
//        System.out.print("num = "+num);
        System.out.println("int 的最大范围是：" + Integer.MAX_VALUE);//获取int类型的最大值
//        System.out.println("int 的最小范围是："+Integer.MIN_VALUE);//获取int类型的最小值
//        char a = '赑';//可以表示一个汉字
//        //布尔类型，只能表示真假，与C不一样，C中0表示假，非0表示真。
//        boolean value = true;
//        boolean value1 = false;
        //创建字符串类型,String是java中已经创建好的一个类，直接拿来用就行了
        String s = "hahahha";
        //使用+号来进行字符串的拼接
        String b = "Hello ";
        String c = "world!";
        System.out.println(b + c);
        System.out.println("my name is \"高瑞杰\"");//遇见要输出双引号的时候，双引号前边和后边加上\即可
        byte a = 10;
        byte d = 20;
        //如果两个操作符都是比int短的类型，就会先统一都转换为int然后再进行运算。
        byte m = (byte) (a + d);//可以直接alt加回车能直接转换过来。
    }
}

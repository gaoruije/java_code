public class java_0920 {
    public static void main(String[] args) {
        //不同类型之间的转换。
        //(1)可以用long来表示int
        int a = 10;
        long b = 20;
        b = a;//因为 b 是long型，所以可以用long型来表示int型
        //(2)不可以用int来表示long，会标红。
        //int c = 10;
        //long d = 20;
        //c = d;
        //(3)可以强制类型转换
        int c = 10;
        byte d =15;
        d = (byte)c;
        //(4)类型提升
        int e = 10;
        long f = 20;
        //int g = e + f;//这个编译会出错，只能转换为表示范围大的。
        long g = e + f;
        //byte和short类型在计算的时候会默认转换为int型，所以最后还得强制类型转换。
        byte h = 10;
        byte i = 10;
        byte j = (byte)(h + i);
        //(5)int 和 String之间的转换
        // a:int 转 String,直接相加即可
        int num = 10;
        String str = num + "";
        // b:String 转 int.用 Integer.parseInk(变量名)。
        String k = "1000";
        int num1 = Integer.parseInt(k);
        //算数运算符，加减乘除。
        //除法的时候，0不能做除数。要是除数为0，结果会是Infinity.
        double l = 6.0;
        double m = 1.5;
        System.out.println(l/m);
    }
}

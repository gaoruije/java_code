public class java_0918 {
    public static void main(String[] args) {
        System.out.println("hello world !");
        int  tmp = 10;//int型占四个字节
        long num = 10L;//long 型占八个字节，long 是后边要加上L.
        double a = 10.3;//double型，
        //神奇的代码（1）
        int b = 5;
        int c = 10;
        //要想输出小数，有三种方法
        //a,直接全部变换类型
        double d = 5;
        double e = 10;
        //b,强制类型转换给前边加要转换的类型即可
        System.out.println((double) b/c);
        //c,隐式类型转换
        double f = 5;
        int g = 10;
        //神奇代码（2）,idea中出来就不神奇了。
        double h = 1.2;
        double i = 1.2;
        System.out.println(h*i);
        System.out.println();
        System.out.println(h*i - 1.44);
        System.out.println(f/g);
        System.out.println(d/e);//类型变了之后就出现小数了。
        System.out.println(b/c);//运行结果是0
        System.out.println(tmp);
        System.out.println(num);
        //float 单精度浮点型，占4个字节.表示的时候一定要给后边加上f，不然会报错
        float j = 1.3f;
        //字符类型（char型）
        char k = 'a';
        System.out.println(k);
    }
}

package java_1006;

public class Student {

    private String id = "1234";
    private String name = "哈哈";

    //给这个类里面写了一个toString方法，然后进行拼接，在另一个类中就能直接调用了。
    public String toString(){
        System.out.println("执行 toString方法后的：");
        return id + ",  " + name;
    }

//    public void print(){
//        System.out.println(id+","+name);
//    }

//    {
//        //构造块
//        System.out.println("这是构造块");
//    }
//    static {
//        //静态代码块
//        System.out.println("这是静态代码块");
//    }
//    public Student(){
//        System.out.println("这是构造方法");
//    }
}

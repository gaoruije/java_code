package Java_2021_01_08;
//创建的一个类，类就是把现实中的属性和行为结合在一起了，光创建一些类是不够的，要是想使用这个类
//还需要根据这个类来创建一些对象出来，也叫做类的实例化，在这个类的围边来进行实例化。
public class Person {
    //1,成员属性,例如这个Person 类就要以下属性
    //直接写在类里边的变量叫成员变量，写在方法里边的变量叫做局部变量。，下边的叫做成员变量。
    String name;//姓名
    int age;//年龄
    String sex;//性别

    //2，成员方法，包含多个方法，里边的和原来写的方法相比少了个static。
    public void eat (String food) {//吃饭的方法。，里边的参数叫做食物
        System.out.println(name + "正在吃" + food);
    }
    public void sleep () {//睡觉的方法
        System.out.println(name + "正在睡觉");
    }
    public void exercise (String sport) {//锻炼的方法。
        System.out.println(name + "正在" + sport);
    }
}

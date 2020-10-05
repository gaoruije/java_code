package java_1005;

public class Student {
    //1,创建一个类分用以下两步
   //a,创建成员变量/字段/属性
    //设定为private之后，就是私有的，只能自己使用，只能在自己的类中使用就是；
    // 也就是说新创建的类就不能用了。
    private String id ;//给ID没有赋值就默认是0.0。
    private String name;
    private Double score;
    //借助idea来实现的 alt + insert.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    //b,创建一些方法,这里是打印的方法。
    public void print(){//这个方法没有加static
        System.out.println("id: "+ this.id
                + ", name: " + name
                + ", score: "+ score);
    }
    //要想程序执行，就必须有一个main方法，这里先在student类里边创建一个main方法
    //注意main方法一定是带static的。
    //在创建一个打印ID的方法,封装的具体体现。
//    public void setId(String id){//设置ID,用set
//        this.id = id;
//    }
//    //创建一个方法为了可以获取ID
//    public String getId(){//get里边不需要参数，直接返回
//        return this.id;
//    }
//    //底下的两个方法是对name进行修改的
//    public String getName(){
//        return this.name;
//    }
//    public void setName(String name){
//        this.name = name;
//    }
    public static void main(String[] args) {
        //2,要想使用以上的方法，这里就必须进行类的实例化，也就是创建一个对象。
        Student student = new Student();//创建了一个对象。
        student.id = "18407020325";
        student.name = "高瑞杰";
        student.score = 4.7;
        student.print();
    }
}

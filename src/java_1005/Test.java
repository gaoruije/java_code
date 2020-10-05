package java_1005;

public class Test {
    //在这个类中进行测试验证，上一个类中方法
    public static void main(String[] args) {
        //记住.的时候是小写。
        Student student = new Student();
        student.setId("18407020325");
        System.out.println("修改后的ID是： "+student.getId());
        student.setName("高瑞杰");
        System.out.println("修改后的名字是： "+student.getName());
//        student.print();
//        //这里是创建了第二个对象student1
//        Student student1 = new Student();
//        student1.print();
    }
}

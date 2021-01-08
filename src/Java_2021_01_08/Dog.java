package Java_2021_01_08;
//这里我们练习一个小狗的类
public class Dog {

        //1,成员属性
        String name;//名字
        String sex;//性别
        int age;//年龄
        String variety;//品种

        //2，创建一些成员方法
        public void eat (String food) {
            System.out.println(name + "正在吃" + food);
        }
        public void sleep () {
            System.out.println(name + "正在睡觉");
        }
    }


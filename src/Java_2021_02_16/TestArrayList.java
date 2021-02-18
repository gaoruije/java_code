package Java_2021_02_16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {
    public static void main(String[] args) {

        //1，先创建一个顺序表，就是创建一个实例。
        //ArrayList<String> arrayList = new ArrayList<>();//要导入那个包
        //因为ArrayList是实现自List的接口，所以也可以按以下的形式来创建实例，后边就可以方便的转换为链表的形式了
        List<String> arrayList = new ArrayList<>();//这里是一个向上转型，就是父类的引用指向了子类的引用。
        //当然后边的所有的操作也就触发了动态绑定，并触发了多态来执行ArrayList内的代码。
        //输出顺序表的长度
        System.out.println(arrayList.size());
        //对顺序表进行判空
        System.out.println(arrayList.isEmpty());

        //2，对顺序表进行插入元素
        // a)核心操作是.add,它是将元素添加在顺序表的末尾的
        arrayList.add("c语言");
        arrayList.add("c++");
        arrayList.add("Java");
        arrayList.add("python");
        arrayList.add("PHP");
        System.out.println(arrayList.size());
        System.out.println(arrayList.isEmpty());
        //b)给顺序表中的指定位置进行添加,里边需要填上两个参数，一个是添加的位置，后边是添加的内容。
        arrayList.add(3,"Javascript");//这里添加的位置还是由0开始的
        System.out.println(arrayList.size());
        //下边我们来进行查看一下具体的元素，直接打印arrayList即可
        System.out.println(arrayList);

        //3，进行删除操作
        //a)进行指定位置的删除
        arrayList.remove(2);
        System.out.println("按照位置来删除" + arrayList);
        //b)按照值来进行删除，要是有多个相同的内容，它是从左向右来进行遍历，只要找见第一个相同的删除后，就不会
        //再进行删除了，就是指删除一个。
        arrayList.remove("PHP");
        System.out.println("按照内容来进行删除" + arrayList);

        //4，进行查找
        //a)查看是否有这个内容，用.contains来进行，其返回子是真或者假
        boolean result = arrayList.contains("java");
        System.out.println("查找java的具体内容 " + result);
        arrayList.add("Java");
        System.out.println(arrayList);
        boolean result1 = arrayList.contains("Java");
        System.out.println("查找Java的内容 " + result1);
        //b)查看这个内容的具体的下标，用.indexOf来进行操作，返回的是一个下标值
        int index = arrayList.indexOf("java");
        System.out.println("查找java的位置 " + index);
        int index1 = arrayList.indexOf("Java");
        System.out.println("查找Java的位置 " + index1);

        //5,获取或者修改元素
        //a)获取元素，.get的方法来进行。
        String elem = arrayList.get(0);
        System.out.println("获取0号元素: " + elem);
        //b)修改元素，用.set的方法来进行的。
        arrayList.set(0,"Go");
        System.out.println("修改后的元素: " + arrayList);

        //6,遍历操作
        //a)通过遍历顺序表的下边数字依次获取顺序表内部的所有的元素
        System.out.println("通过下标来进行顺序表的遍历：");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        //b)通过迭代器来进行遍历
        //先通过iterator来获取到迭代器对象
        System.out.println("通过迭代器来进行遍历元素：");
        Iterator<String> iterator = arrayList.iterator();//这里的顺序表就是iterator的对象
        //再用while循环来进行遍历
        while (iterator.hasNext()) {
            String elem1 = iterator.next();
            System.out.println(elem1);
        }
        //c)使用for—each来进行遍历,本质上还是基于迭代器来进行实现的。
        System.out.println("通过for—each来实现的遍历：");
        for (String e: arrayList) {
            System.out.println(e);
        }
    }
}

package java_1006;

public class SeqList {
    //先提供一个连续的内存空间的存储，这里就创建一个数组，作为一个属性。
    private int[] data = null;//将数组初始化为null，就是一个空引用，一会赋值的时候才分配空间。
    //这里的操作是构造方法，就是对属性进行初始化
    public SeqList() {
        data = new int[1000];//先创建了一个长度为1000的数组。
    }
}

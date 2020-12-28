package java_2020_12_28;

public class PrintfAllDaffodils {
    public static void main(String[] args) {
        //1,直接进行调用方法
        PrintAllDaffodils(0,999);
    }
    //2,这里是打印的方法，只管打印即可
     public static void PrintAllDaffodils(int begin, int end) {
        for(int i = begin; i <= end; i++) {
            if(IsDaffodils(i)) {//这里需要一个判断的方法，下边进行创建
                System.out.println(i);
            }
        }
    }
    //3,判断是否是水仙花的方法
    public static boolean IsDaffodils(int num) {
        //提取个位
        int gewei = num % 10;
        //提取十位
        int temp = num / 10;
        int shiwei = temp % 10;
        //提取百位
        int temp1 = num / 100;
        int baiwei = temp1 % 10;
        if(Cube(gewei) + Cube(shiwei) + Cube(baiwei) == num) {//这里有一个求立方的方法。
            return true;
        } else {
            return false;
        }
    }
    //4，创建求和的方法
    public static int Cube(int i) {
        return i * i * i;
    }
}

package java_2020_12_27;

public class Themin {
    public static void main(String[] args) {
        //求两个数字中的最大值
        System.out.println(Themin(4,5));
    }
    public static int Themin(int a,int b){
        int Themin = 0;
        if(a < b){
            Themin = a;
        } else if(a > b){
            Themin = b;
        }else{
            System.out.println("这两个数字相等");
        }
        return Themin;
    }
}

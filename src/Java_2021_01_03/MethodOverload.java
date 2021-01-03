package Java_2021_01_03;


public class MethodOverload {
    public static void main(String[] args) {
        //题目要求：在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，
        // 还可以求两个小数的最大值，以及两个小数和一个整数的大小关系
        //1,两个整数最大值
        System.out.println(Seekmax(5,8));
        //2,两个小数最大值
        System.out.println(Seekmax(3.3,8.3));
        //3,两个小数和一个整数的最大值
        System.out.println(Seekmax(1.2,4.5,0));
    }

    //整数和整数
    public static int Seekmax(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    //小数和小数。
    public static double Seekmax(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    //两个整数和一个小数的关系。
    public static double Seekmax(double a, double b,int c) {
        double x = (double)Seekmax(a,b);
        double y = (double)Seekmax(a,c);
        double result = Seekmax(x,y);
        return result;
    }

    public static double Seekmax(double a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}

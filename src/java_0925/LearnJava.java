package java_0925;

public class LearnJava {
    public static void main(String[] args) {
        //用方法来实现交换两个数字。
            //a,还是先要在外边写一个能交换整数的方法 swap
            //b,在main中调用下边写的方法
            int[] arr = {12,23,45,34,55};
            swap(arr);//调用的是swap方法。
            System.out.println("a = " +arr[0] +"      "+"b = " +arr[1]);
            int ret = add(20,30);//调用的是add方法,实现的是两个整数的相加。
            System.out.println(ret);
            double ret1 = add(2.4,5.6);//调用的是add方法，实现的是两个小数相加。
            System.out.println(ret1);
            int ret2 = add(10,20,30);//调用的是add方法，实现的是三个整数相加。
            System.out.println(ret2);
            //a,通过一般的方法求阶乘。写一个方法来调用就行了。
            int ret3 = factor(5);
            System.out.println(ret3);//运行的最后结果是120.
            //b,通过递归版本来求阶乘，核心是拆分，底下已经写好方法了，现在直接调用
            int a = factor1(4);
            System.out.println(a);

        }
        //这里是创建了一个交换整数的swap方法
        public static void swap(int[] arr){
            int tmp = arr[0];
            arr[0] = arr[1];
            arr[1] = tmp;
        }
        //这里是创建了一个两个整数相加的addInt方法
        public  static int add(int x, int y){
            return x + y;
        }
        //创建一个交换两个小数交换的addDouble方法
        public static double add(double x,double y){
            return x + y;
        }
        //创建一个实三个整数相加的方法
        public static int add(int x,int y, int z){
            return x + y + z;
        }
        //创建了一个求阶乘的方法 factor
        public static int factor(int n){
            int result = 1;
            for(int i = 1;i <= n;i++){
                result *= i;
            }
            return result;
        }
        //创建一个能用递归实现的方法,上边进行调用即可。
        public  static int factor1(int n){
            if(n == 1){
                return 1;
            }
            return n *= factor1(n-1);
        }
    }


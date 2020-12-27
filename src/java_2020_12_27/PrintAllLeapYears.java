package java_2020_12_27;

public class PrintAllLeapYears {
    public static void main(String[] args) {
        PrintAllLeapYears(1000,2000);
    }
    //还是次方法只管打印闰年
    public static void PrintAllLeapYears(int begin,int end){
        System.out.println("所有的闰年如下：");
        for(int year = begin; year <= end; year++) {
            if (Isleap(year)) {
                System.out.print(year + " ");
            }
        }
    }
    public static boolean Isleap(int year) {
        if(year % 100 == 0){
            //1，世纪闰年
            if(year % 400 == 0){
                return true;
            }else{
                return false;
            }
        }else{
            if(year % 4 == 0){
                return true;
            }else{
                return false;
            }
        }
    }
}

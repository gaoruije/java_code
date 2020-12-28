package java_2020_12_28;

public class PrintMultiplicationtable {
    public static void main(String[] args) {
        ShowMultiplicationtable();
    }

    public static void ShowMultiplicationtable() {
        //1，有9行，我们先考虑行，一会单独考虑每一行有多少列
        for (int Row = 1; Row <= 9; Row ++){
            Print(Row);
        }
    }

    //此方法只考虑打印每一行内部的内容。
    public static void Print(int Row) {
        for (int Column = 1; Column <= Row; Column ++) {
            System.out.printf("%dX%d=%-2d ",Column,Row,Column*Row);
        }
        //每循环完一轮后，要换行
        System.out.println();
    }
}

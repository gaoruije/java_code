package java_1004;

public class DoubleArray {
    public static void main(String[] args) {
        //1,二维数组的创建
        int [][] arr = {
                {1,2,3},
                {4,5,6,7},
                {1,2,3,4,5,6}
        };
        //2,二维数组的遍历，先遍历数组的每一行，在遍历数组的每一列。
        for(int row = 0; row < arr.length; row++){//遍历的是行。
            for(int col = 0; col < arr[row].length; col++){
                //这里是打印每一行内的每一个元素
                System.out.print(arr[row][col]+"  ");
            }
            //打印的是换行
            System.out.println();
        }
    }
}

package Java_2021_01_20;

import java.util.ArrayList;
import java.util.List;

public class printYangHuiTriangle {
    public static void main(String[] args) {
        System.out.println(generate (5));
    }

    // 来进行一个杨辉三角的方法
    public static List<List<Integer>> generate (int numberRows) {
        // 1，首先要考虑周全，考虑到要是传入小于1的数字
        if (numberRows < 0) {
            return new ArrayList<>();//要是有小于1的数字，直接返回一个空的顺序表即可
        }

        // 2,再来进行杨辉三角的前两行
        // result表示的是显示最后的结果的，就是先准备一个大框子
        List<List<Integer>> result = new ArrayList<>();
        // 再给大框子里边构建出小的框子
        List<Integer> firstLine = new ArrayList<>();
        // a)处理第一行，就一个元素，直接插入
        firstLine.add(1);//将1放入小框子
        result.add(firstLine);//将小框子放入大框子
        if (numberRows == 1) {
            return result;
        }
        // b)处理第二行
        List<Integer> secondLine = new ArrayList<>();//创建一个小框子
        // 下边是给小框子里边装入元素
        secondLine.add(1);
        secondLine.add(1);
        // 将小框子里边的东西放入大框子
        result.add(secondLine);
        if (numberRows == 2) {
            return result;
        }
        // 3.处理剩下的行数
        // a)每一行的前一个和最后一个元素都是1
        // b)每一行的行数和列数都是相同的
        // c)第i行的J好元素的值 = i - 1 行的 j - 1 + j 的值
        for (int row = 3; row <= numberRows; row++) {
            // 这里是创建的一个得上一行的对象,row - 1 表示的是找到 row - 1 行，在减一表示的是得到下标
            List<Integer> prevLine = result.get(row - 1 - 1);
            List<Integer> currentLine = new ArrayList<>();//创建小的框子
            currentLine.add(1);//第一个元素是1
            // 处理中间的元素
            for (int col = 2; col < row; col++) {
                // 这里有一重循环，必须依据于上一行的元素
                // 获取两个元素的值，用 .get 操作
                int num1 = prevLine.get(col - 1);//获取的 row 行 col 列的元素的值
                int num2 = prevLine.get(col -1 -1);//获取 row 行 col -1 列的元素的值
                // 进行插入元素值,给小框子里边插入
                currentLine.add(num1 + num2);
            }
            currentLine.add(1);//最后一个元素也是1
            // 将小框子中的东西给大框子中插入
            result.add(currentLine);
        }
        return result;
    }
}

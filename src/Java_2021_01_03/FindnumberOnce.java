package Java_2021_01_03;

public class FindnumberOnce {
    //题目要求：有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
    public static void main(String[] args) {
        int[] arr = {9,9,5,5,7,7,6,6,8,8,4,4,345,2,2,3,3};
        //1，调用找数字的方法
        System.out.println(" 唯一出现过一次的数字是：" + FindNumber(arr));
    }

    //2,只管找多少次
    public static int FindNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //要是出现一次，返回arr[]
            if (Isonce(i,arr)) {
                return arr[i];
            }
        }
        return -1;
    }

    //3,每一轮中进行找，要是只出现一次，返回true，否则返回false
    public static boolean Isonce(int i,int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            //**发现有一样的了,注意后边的那个除过自己和自己相等的情况，也就是i和j相等的情况要除去。
            if ((arr[i] == arr[j]) && (i != j)) {
                return false;
            }
        }
        //所有的都找完了，则说明没有和其一样的，返回true。
        return true;
    }
}

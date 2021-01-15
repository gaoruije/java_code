package Java_2021_01_15;

public class CaseConversion {
    //实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，
    // 之后返回新的字符串。
    //大小写相差32，大写的数字小，小写的数字大。
    public static void main(String[] args) {

        //方法1：在字符的基础上，对每个字符进行操作。
        System.out.println(ToLowerCase("HeLLo"));

        //方法2：用位运算来进行解决
        //a：所有的字符转化为大写，  字符 &= 33；
        //b:所有的字符转化为小写,  字符 |= 32；
        //c：大变小，小变大，  字符 ^= 32
        System.out.println(ToLowerCase1("GaoRUiJIE"));
    }

    public static String ToLowerCase1(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            ch[i] |= 32;
        }
        return String.valueOf(ch);
    }

    public static String ToLowerCase(String str) {
        //a:判空,字符串为空，或者字符串的长度是空的，就直接返回字符串即可
        if (str == null || str.length() == 0) {

        }
        //b:先将传进来的字符串转化成字符数组，下边在对每一个字符所对应的十进制数字进行操作即可
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            //要是大写，进行转化,小写的话，不进行任何操作。
            if ((ch[i] >= 'A') && (ch[i] <= 'Z')) {
                //有一个强转，将int转成char型。
               ch[i] = (char) (ch[i] + 32);
            }
        }
        //上边就是已经全部转换完之后的字符串，进行输出即可。
        return String.valueOf(ch);
    }

}

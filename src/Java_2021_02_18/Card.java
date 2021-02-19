package Java_2021_02_18;

//这里是创建的一个牌的类
public class Card {
    //1，属性有花色和点数
    public String suit;//创建的花色
    public String rank;//创建的点数

    //2，创建花色和点数是为了后边进行用的，所以还是为了进行实例化，采用构造方法来进行。
    //进行实例化，alt加insert，全选。
    public Card(String suit,String rank) {
        this.rank = rank;
        this.suit = suit;
    }
    //3，后边要进行对牌的内容的输出，要来一个方法重写。就是用到了toString来进行

    @Override
    public String toString() {
        return "(" + this.suit + this.rank + ")";
    }
}

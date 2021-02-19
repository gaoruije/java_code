package Java_2021_02_18;
//创建了一个扑克牌游戏的类

import java.util.ArrayList;
import java.util.Collections;//util中直接提供的洗牌的方法
import java.util.List;
import java.util.Random;

public class PokerGame {
    //1,先弄一个牌的花色的数组，让它不能被修改，用到关键字final
    private static final String[] suit = {"♥", "♠", "♣", "♦"};

    //2，弄一个容器来放所有的牌，包括牌的花色和点数
    //这里选择用顺序表来进行接收，要导入。
    private static List<Card> buyJoker() {
        //向上转型，父类的引用指向子类的引用。
        List<Card> poker = new ArrayList<>();
        //外层控制花色
        for (int i = 0; i < 4; i++) {
            //内层循环用来控制点数
            for (int j = 2; j <= 10; j++) {
                poker.add(new Card(suit[i], String.valueOf(j)));//这里要将int转化成String类型的，String.valueOf
            }
            //插入JQKA。
            poker.add(new Card(suit[i], "J"));
            poker.add(new Card(suit[i], "Q"));
            poker.add(new Card(suit[i], "K"));
            poker.add(new Card(suit[i], "A"));
        }
        //插入大小王
        poker.add(new Card(" ", "Gig Joker"));
        poker.add(new Card(" ", "Small Joker"));
        return poker;
    }

    //3,进行洗牌操作,List是可变对象，直接修改poker就会对List造成影响
    private static void shuffle(List<Card> poker) {
        //要随机的生成一个随机数，这里用到random
        Random random = new Random();
        //从后向前遍历List中的所有元素，依次和前边的随机数交换顺序
        for (int i = poker.size() - 1; i > 0; i--) {
            int pos = random.nextInt(i);//产生了一个[0,i)的随机数字
            //交换两个内部的内容
            swap(poker,i,pos);
        }
    }

    private static void swap(List<Card> poker, int i, int pos) {
        //交换两个的顺序
        Card temp = poker.get(i);//获取了poker里边的一个下标
        poker.set(i,poker.get(pos));//将生成的随机数的位置赋值给i的位置
        poker.set(pos,temp);//将原来poker的下标放到pos位置
    }

    public static void main(String[] args) {
        //1,创建一副扑克牌
        List<Card> poker = buyJoker();//是一个向上转型
        //2，进行洗牌操作
        //基本思路：从后向前遍历数组，每拿到一个元素，就将其和它前边的一个随机位置的牌来进行交换即可。
        shuffle(poker);
        //实际开发过程中，不需要自己去写洗牌算法，直接用collection类里边的shuffle即可
        //Collections.shuffle(poker);
        System.out.println(poker);

        //3,实现发牌过程，假设有3个玩家，每个玩家3张牌
        //因为有三个玩家，所以这三个玩家可以放在一个顺序表中，
        // 每个顺序表中又是3张牌，这三张牌又放在一个List内
        //法1，创建三个玩家，让每个玩家内的牌在一个ArrayList内
//        List<Card> player1 = new ArrayList<>();//第一个玩家手中的牌又是一个顺序表
//        List<Card> player2 = new ArrayList<>();
//        List<Card> player3 = new ArrayList<>();
        //法2，因为玩家有可能很多，所以用一个List内部的参数List<Card>
        List<List<Card>> players = new ArrayList<>();
        //每次add的元素都是一个 ArrayList<Card> 类型,表示的是三个玩家，所以add三次
        for (int i = 0; i < 3; i++) {
            players.add(new ArrayList<>());
        }
//        players.add(new ArrayList<>());
//        players.add(new ArrayList<>());
//        players.add(new ArrayList<>());
        //进行发牌,先给每个人发，发够三轮即可
        //外层循环控制的是共3轮，也就是3张牌
        for (int i = 0; i < 3; i++) {
            //内层循环控制的是人数
            for (int j = 0; j < 3; j++) {
                //意思是从第一张进行发牌，将手牌先删掉，返回的是一个下标。
                Card top = poker.remove(0);
                //获得玩家的序号
                List<Card> player = players.get(j);
                //给玩家进行发牌，就是直接给玩家中进行添加
                player.add(top);
            }
        }
        //4,展示牌
        for (int i = 0; i <players.size(); i++) {
            List<Card> player = players.get(i);
            System.out.println("玩家" + i + " 的手牌是：" + player);
        }
    }
}
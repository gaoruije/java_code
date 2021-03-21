package java_2021_03_21;

import java.util.Scanner;

// 先把树构建好
class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;

    public TreeNode(char val) {
        this.val = val;
    }
}

public class createTree {
    // 题目要求：提供一个先序遍历结果的二叉树，要求构建这棵树，并以中序遍历的方式打印这棵树

    public static void main(String[] args) {
        // 因为要读取数据，要用到scanner,他还能读取文件等等
        Scanner scanner = new Scanner(System.in);
        // 系统给的测试用例是多组的，要用到循环
        while (scanner.hasNext()) {// 要是scanner能读到数据，就继续循环
            // 用一个line将读到的所有的数据放在line中.
            String line = scanner.next();
            // 读到一个数字就进行一次树的构建，值到读完为止.
            TreeNode root = build(line);
            inOrder(root);
            // 每出一次while就是一个新的测试用例，要换行.
            System.out.println();
        }
    }
    // String line 中的每一个字符就是一个节点,我了方便知道自己每一步取到那个字符了
    public static int index = 0;
    // 创建方法
    public static TreeNode build(String line){
        // 用例可能有多组，每次进来之前将斤index设置为0,保证每次用例不然一块
        index = 0;
        return _build(line);//辅助递归方法
    }
    public static TreeNode _build(String line) {// 注意里边的参数，传的是一个字符串，在进行构造的
        // 先根据index将当前节点获取到
        char ch = line.charAt(index);// 获取下标字符
        if (ch == '#') {// 要是见到#，就是没有节点，也就是null,返回null即可。
            return null;
        }
        // 要是不是空的树，就用一个节点两这个字符串接收一下
        TreeNode root = new TreeNode(ch);
        index++;// 获取下一个字符
        root.left = _build(line);// 给根节点找左右子树,访问操作是树的构建
        index++;
        root.right = _build(line);
        return root;
    }
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");// 注意牛客之中的格式
        inOrder(root.right);
        // 要注意，每一个用例之间也是不能然在一块的.
    }
}

package java_2021_03_21;

public class Tree2str {
    // 题目要求：将二叉树转化成为字符串，注意内部的括号，只有根的左子树为空并且右子树不为空的时候，那个括号
    // 才加上，否则全部省略
    // 1.创建一个可变的版本的的字符串,放在外边
    public StringBuilder stringBuilder = null;
    public  String tree2str(TreeNode t) {
        // 保证每个用例之间不影响，里边进行初始化
        stringBuilder = new StringBuilder();
        // 特殊情况的处理
        if (t == null) {// 要是树是空的，返回空的字符串
            return "";
        }
        // 要是不是空的，进行辅助方法的调用
        _tree2str(t);
        // 下边的调用完后，前边和后边要去括号
        stringBuilder.deleteCharAt(0);// 删除的是左括号
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        // 进行完成后，返回
        return stringBuilder.toString();
    }

    public void _tree2str(TreeNode root) {
        if (root == null) {
            return;
        }
        // 题目中要求加上括号的，在每一次处理之前加上
        stringBuilder.append("(");
        // 再进行先序遍历，访问操作是将值插入到stringBuilder 中去
        stringBuilder.append(root.val);
        // 递归处理左右子树
        _tree2str(root.left);
        // 注意添加的位置,要是一个根的左子树是空的，右子树不是空的，就要加上括号
        if (root.left == null && root.right != null) {
            System.out.print("()");
        }
        _tree2str(root.right);
        stringBuilder.append(")");
    }
}

package java_2021_03_21;

import java.util.ArrayList;
import java.util.List;

public class buildTree {
    // 题目要求：给定先序和中序遍历结果，要求构造出二叉树
    // 为了用例之间的不冲突，还想知道自己当前处理到哪个字符串，弄一个index
    public static int index = 0;

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        // 保证每次用例之间不影响，每次将index置零
        int index = 0;
        // 1.为了方便后边截取中序遍历的某个部分没讲数组转换为List<Integer>,弄个顺序表,将数组中的东西全部插入
        List<Integer> inOrderList = new ArrayList<>();
//       for (int i = 0; i < inOrder.length; i++) {
//           inOrderList.add(inOrder[i]);
//       }
        for (int x : inOrder) {
            inOrderList.add(x);
        }
       return _buildTree(preOrder,inOrderList);
    }

    public TreeNode _buildTree(int[] preOrder,List<Integer>inorder) {
        if (inorder.isEmpty()) {
            return null;
        }
        if (index >= preOrder.length) {// 前序遍历完了
            return null;
        }
        TreeNode root = new TreeNode((char)preOrder[index]);// 这里先强转一下，后边改TreeNode 中的类型
        index++;
        // 递归处理左右子树
        // 左右子树的中序遍历结果在本棵树中，只要知道中序的根在哪就行了
        int pos = inorder.indexOf(root.val);// 将根记录下来
        root.left = _buildTree(preOrder,inorder.subList(0,pos));// 这个方法是前闭后开的
        root.right = _buildTree(preOrder,inorder.subList(pos+1,inorder.size()));
        return root;
    }
}

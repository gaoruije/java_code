package java_2021_0330;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePracticeCode2 {
    // 树的构建
    public static TreeNode build() {
            TreeNode a = new TreeNode(1);
            TreeNode b = new TreeNode(2);
            TreeNode c = new TreeNode(3);
            TreeNode d = new TreeNode(4);
            TreeNode e = new TreeNode(5);
            TreeNode f = new TreeNode(6);
            TreeNode g = new TreeNode(7);
            a.left = b;
            a.right = c;
            b.left = d;
            b.right = e;
            c.left = f;
            e.right = g;
            return a;
    }
    // 8.求二叉树中第K层的所有的节点和
    // 基本思路：k层的所有节点之和就是K - 1层的左右子树的节点之和
    public static int getKLeafSize (TreeNode root,int k) {
        // 特殊情况的处理
        if (root == null || k < 1) {
            return 0;
        }
        // 递归结束的条件，就是K在第一层的时候，返回1，一层只有一个节点
        if (k == 1) {
            return 1;
        }
        return getKLeafSize(root.left, k - 1) + getKLeafSize(root.right, k - 1);
    }

    // 9.找二叉树中是否存在某个节点
    public static TreeNode find(TreeNode root,int toFind) {
        // 特殊情况处理
        if (root == null) {
            return null;
        }
        // 然后看看树根是否与要找的元素一样
        if (root.val == toFind) {// 找见了，就直接
            return root;
        }
        // 用一个框子来存遍历左子树的结果
        TreeNode result = find(root.left,toFind);
        // 下边看看左子树里边有没有要找的那个元素
        // 要是能result出结果说明找见了，返回result
        if (result != null) {
            //找见了，就进行返回
            return result;
        }
        // 否则递归处理右子树
        return  find(root.right,toFind);
    }

    // 10.给定一个二叉树，先序遍历二叉树，并将先序遍历后的结果放在一个顺序表中
    public List<Integer> preOrderTraversal(TreeNode root) {
        // 由题目可知要返回的是一个顺序表，所以先创建一个顺序表用来存元素
        // 这里要创建一个框框的，要是二叉树是空的话，也是要返回那个框框的,弄了一个顺序表
        List<Integer> list  = new ArrayList<>();// 泛型参数里边要填的是包装类
        // 特殊情况处理
        if (root == null) {
            return list;//一定返回的是list也就是空的框框，可不敢直接返回null，最起码人家有个框框呢
        }
        // 除过上边的情况，说明根节点不是空的了，就将根节点插入
        // 先序遍历的，所以先进行访问操作，就是将节点给顺序表中插入
        list.add(root.val);
        // 再递归处理左右子树，因为左右子树的处理结果是一串数字，直接将这一串数字插入
        list.addAll(preOrderTraversal(root.left));
        list.addAll(preOrderTraversal(root.right));
        return list;
    }

    // 11.给定一个二叉树，中序遍历二叉树，并将遍历后的结果方在顺序表中去
    public static List<Integer> inOrderTraversal(TreeNode root) {
        // 还是先创建一个顺序表用来存数据
        List<Integer> list = new ArrayList<>();// 发现这也是一个向上转型哦
        // 要是根节点是空的话，直接返回创建的那个空的顺序表框框即可
        if (root == null) {
            return list;
        }
        // 到了这里就说明根节点一定不是空的了，要是中序遍历，就先进行递归
        // 还是递归左子树的最终结果一定是一串数字，我们将这一串数字插入
        list.addAll(inOrderTraversal(root.left));
        // 在进行插入根节点的操作
        list.add(root.val);
        // 最后再遍历右子树
        list.addAll(inOrderTraversal(root.right));
        return list;
    }

    // 12.二叉树的后序遍历，将遍历的结果放在一个顺序表中
    public List<Integer> postorderTraversal(TreeNode root) {
        // 创建顺序表
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        // 递归插入左子树
        list.addAll(postorderTraversal(root.left));
        list.addAll(postorderTraversal(root.right));
        // 最后进行根节点的插入
        list.add(root.val);
        return list;
    }

    // 13.给定两颗树判定这两颗树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 首先看看看看两个树有没有根
        // 1.两个树都是空的，认为两个树是相同的
        if (p == null && q == null) {
            return true;
        }
        // 2.要是一个树是空的一个树不是空的，则一定不相同
        if (p == null || q == null) {
            // 表示两个里边一个空一个不空，注意这里不可能两个都空，要是两个都空的话，就进入上边的条件了
            return false;
        }
        // 2.两个数都不空了
        // 要是两个非空树的不相同，则一定不相同,不用再给下走，直接返回false
        if (p.val != q.val) {
            return false;
        }
        // 要是两个树的根是相同的，就递归看看两个树的左右子树是否都是相同的
        // 注意条件要必须是都相同才能说明两个树是相同的
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    // 14.给定两颗二叉树S和T，看看S中是否包含T
    // 1.判断两个树是否一样
    public boolean isSameTree1(TreeNode s,TreeNode t) {
        // 特殊处理
        if (s == null && t == null) {
            return true;
        }
        // 一个树为空，一个数不为空
        if (s == null || t == null) {
            return false;
        }
        // 上边已经保证两个树都不空了，看看他们的根是否一样
        if (s.val != t.val) {
            // 要是根不相同，则直接返回false
            return false;
        }
        // 返回左右子树的共同判定结果
        return isSameTree(s.left,t.left) && isSameTree(s.right,t.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 特殊情况的判断
        if (s == null) {
            return false;
        }
        // 说明两个树不是空的了，然后就看看他们两个是相同的树，调用前边的方法
        boolean ret = isSameTree1(s,t);
        if (ret) {
            return ret;
        }
        // 否则检查S的左子树和右子树是否包含T
        // 注意条件，只要左右子树中只要有一个包含T即可
        return isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    // 15.求二叉树的最大深度，也就是求高度
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    // 16.判断一个树是否是平衡二叉树
    // 一棵树要是满足每一个节点的左右子树高度差不超过1，就是平衡的，否则不平衡
    public int getLength(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getLength(root.left);
        int rightHeight = getLength(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
        // 平衡二叉树的每个节点的高度差不能超过1，肯定要求左右子树的高度
        // 特殊情况处理
        if (root == null) {
            return true;
        }
        // 就一个根节点的情况
        if (root.left == null && root.right == null) {
            return true;
        }
        // 走到这里就说明树一定是有两个以上节点了，就可以比较看左右子树的高度之差是否大于等于1
        // 上边传入的是一个根，这里就要计算这个根的左右子树的高度
        int leftHeight = getLength(root.left);
        int rightHeight = getLength(root.right);
        if ((leftHeight - rightHeight > 1) || (leftHeight - rightHeight < -1)) {
            return false;
        }
        // 要是高度之差小于1，就直接递归处理，左右子树，条件是都要哦
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 17.判断一棵树是否是对称二叉树
    public boolean isSymmetric(TreeNode root) {
        // 特殊情况处理
        if (root == null) {
            // 要是树是空的则认为是镜像对称的
            return true;
        }
        // 树不为空的情况，借助一个镜像方法来进行判断
        return isMirror(root.left,root.right);
    }

    // 这里是判断一棵树是否是镜像的方法
    public boolean isMirror(TreeNode p,TreeNode q) {
        // 要是p和q都是空的，也就是说原来的树只有一个根节点的时候，树也是对称的
        if (p == null && q == null) {
            return true;
        }
        // 要是树有根节点，但是根节点的左右子树一个是空的话，说明树一定不是对称的
        if (p == null || q == null) {
            // 这个条件只可能是其中的一个是空的，要是两个都是空的，就走到上边的入口了
            return false;
        }
        // 走到这里说明原来的树一定有左右子树了
        // 判断一下左右子树的值是否相同，要是相同的话，才有向下走的意义，不相同的话，直接返回false
        if (p.val != q.val) {
            return false;
        }
        // 这里说明原来输的左右子树也是相同的，进行递归处理左右子树的左右子树
        // 看一下，左子树的左子树和右子树的右子树，还有左子树的右子树和右子树的左子树是否镜像
        // 注意条件是两个都要满足的
        return isMirror(p.left,q.right) && isMirror(p.right,q.left);
    }

    public static void main(String[] args) {
        TreeNode root = build();
        //System.out.println(getKLeafSize(root,4));
        System.out.println(find(root,4));
    }
}

package java_2021_0329;

public class binaryTreePracticeCode {

    // 1.二叉树的构建
    public static TreeNode createTree() {
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

    // 2.二叉树的前序遍历
    public static void prevOrder(TreeNode root) {
        // 特殊情况处理
        if (root == null) {
            return;
        }
        // 先进行访问，在处理左右子树
        System.out.print(root.val + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    // 3.二叉树的中序遍历
    public static void inOrder(TreeNode root) {
        // 特殊情况处理
        if (root == null) {
            return;
        }
        // 先处理左子树，在进行访问操作，再进行右子树递归
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 4.二叉树后序遍历
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    // 6.求二叉树的高度
    public static int getLength(TreeNode root) {
        // 返回1 + 左边和右边子树高的子树
        // 1.特殊情况处理
        if (root == null) {
            return 0;
        }
        int leftHeight = getLength(root.left);
        int rightHeight = getLength(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    // 7.求二叉树中的所有叶子节点个数
    public static int getLeafSize(TreeNode root) {
        // 特殊情况处理
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    // 8.

    public static void main(String[] args) {
        TreeNode root = createTree();
        //prevOrder(root);
        //inOrder(root);
        //postOrder(root);
        System.out.println(getLeafSize(root));
    }
}

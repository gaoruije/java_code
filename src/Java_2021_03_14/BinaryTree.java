package Java_2021_03_14;

// 和链表很相似，二叉树也是有节点这个类的
// 下边就进行对节点的创建
class Node{
    public String val;
    Node left;
    Node right;

    public Node(String val) {
        this.val = val;
    }
}

// 实现二叉树的基本操作
public class BinaryTree{
    // 1.二叉树的构建,跟链表很相似，链表是只有一个next，这有两个。最后返回那个头就行了
    public static Node build() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;
    }

    // 2.先序遍历二叉树，（根左右）。
    public static void preOrder(Node root) {
        // a.特殊情况的处理
        if (root == null) {
            return;
        }
        // b.一般情况的处理
        // 先访问根节点，这里的访问指的是打印，访问指的是一种操作
        System.out.print(root.val + "  ");// 打印的是根的值，用的是val。
        // 递归遍历左子树
        preOrder(root.left);
        // 递归遍历右子树
        preOrder(root.right);
    }

    // 3.中序遍历二叉树,（左根右）。
    public static void inOrder(Node root) {
        // a.特殊情况的处理
        if (root == null) {
            return;
        }
        // b.一般情况的处理
        // 先去递归处理左子树
        inOrder(root.left);
        // 再访问根节点
        System.out.print(root.val + "  ");
        // 最后递归处理右子树
        inOrder(root.right);
    }

    // 4.后序遍历二叉树(左右根)。
    public static void postOrder(Node root) {
        // a.特殊情况的处理
        if (root == null) {
            return;
        }
        // b.一般情况的处理
        // 先递归处理左子树
        postOrder(root.left);
        // 再递归处理右子树
        postOrder(root.right);
        // 最后进行打印根节点
        System.out.print(root.val + "  ");
    }

    // 5.求二叉树的所有节点的个数
    // 基本思想：将树分为左边的书和右边的树，就是不断的递归
    public static int length(Node root) {
        // t特殊情况的处理
        if (root == null) {
            return 0;
        }
        // 返回那个头节点的节点数1 + 左右子树的递归
        return 1 + length(root.left) + length(root.right);
    }

    // 6.求二叉树中的所有的叶子节点的和
    // 基本思想：先判断空，还有判断只有一个节点是不是叶子节点，再递归遍历左右子树
    public static int getLeafSize(Node root) {
        // 特殊情况的处理
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        //最后遍历左右子树
        return getLeafSize(root.left) + getLeafSize(root.right);
    }

    // 7. 求第K层的节点个数
    // 基本思想：求得K层的节点个数转化为求第k-1层的左子树的节点个数 + k-1层的右子树的个数
    public static int sizeNodeOfK(Node root,int k) {
        // 特殊情况的处理
        if (root == null || k <= 0) {// root == null 的时候，也得返回，不然就多了一个节点
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        // 处理一般情况
        return sizeNodeOfK(root.left,k-1) + sizeNodeOfK(root.right,k-1);
    }

    // 8.求二叉树的高度
    // 基本思想：整棵树的高度可以转化为1 + 左右子树的最大高度，核心还是进行递归
    public static int getHeight(Node root) {
        // 特殊情况处理
        if (root == null) {
            return 0;
        }
        // 一般情况处理
        int leftHeight = getHeight(root.left);// 将左子树的高度递归处理记为leftHeight
        int rightHeight = getHeight(root.right);// 右子树的高度记为rightHeight
        // 进行判断,这个就是要是满足返回前边，要是不满足返回后边。
        return 1 + (leftHeight > rightHeight ? leftHeight: rightHeight);
    }

    // 9.查找二叉树中间的节点
    public static Node findNode(Node root,String val) {
        // 特殊情况的判定
        if (root == null) {
            return null;
        }
        // 一般情况的处理
        if (root.val.equals(val)) {// 返回的值是真或者假，进入就说明是真的，找到了
            return root;
        }
        // 要是根节点没有找见，就递归遍历左子树
        Node result = findNode(root.left,val);
        if (result != null) {//说明要找的那个元素在左子树里边，直接返回
            return result;// 返回的是result，最起码要把人家的框框返回回来
        }
        // 走完上边就说明说明左子树里边也没有找见，递归遍历右子树
        return findNode(root.right,val);// 要死找见就会返回，要是没有找见就会返回空
    }



    public static void main(String[] args) {
        Node root = build();
        //System.out.print("二叉树的第k层的节点个数是：" +  getHeight(root));
        //preOrder(root);
        //inOrder(root);
        //postOrder(root);
        System.out.print(findNode(root,"H"));
    }
}


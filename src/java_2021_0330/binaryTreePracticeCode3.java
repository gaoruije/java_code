package java_2021_0330;

import java.util.LinkedList;
import java.util.Queue;

public class binaryTreePracticeCode3 {

    // 18.层序遍历二叉树
    public static void levelOrder(TreeNode root) {
        // 特情况的处理
        if (root == null) {
            return;
        }
        // 借助队列实现层序遍历，创建一个队列用来辅助进行层序
        // 注意队列不能之间new出来，要用一个LinkedList
        Queue<TreeNode> queue = new LinkedList<>();
        // 将二叉树中的根节点先插入进去，不用进行判定根是否是null了，上边已经走过了
        queue.offer(root);
        // 下边进行循环，要是不知道条件可以直接先来一个死循环，在达到条件的时候直接跳出循环即可
        while (true) {
            // 将刚入队列的值再出队列，用一个临时变量来存下出队列的值
            TreeNode temp = queue.poll();
            // 进行判断，是否进行访问操作
            if (temp == null) {// 队列里边已经是空的了，直接跳出循环
                break;
            }
            // 走到这一步说明队列的最后一个元素还不是空的，进行访问操作
            System.out.print(temp.val + " ");
            // 出了队列之后再对temp的左右子树进行判定，要是不是空的话，就直接进行入队操作
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    // 19.判断一颗二叉树是否是完全二叉树
    // 基本思想：就是二叉树的右边的部分是空的即可了
    // 解决步骤：分为两个阶段
    // 一阶段：又分为四个阶段，分别是左右都空，左空右不空（直接不是二叉树），左不空右空（进入第二阶段），
    // 左右都空（进入第二阶段）。
    // 二阶段：层序遍历下一个节点，要是下一个节点有一个是有值的，就不是完全二叉树，
    // 要是两个子树都是空的，则就是完全二叉树
    public static boolean isCompleteTree(TreeNode root) {
        // 特殊情况的处理
        if (root == null) {
            return true;
        }
        // 一般情况处理
        // 先设定一下阶段，先是阶段一,就设置阶段2是false，到时触发阶段2直接在将阶段2置为true即可
        boolean level2 = false;
        // 层序遍历二叉树，看看它们的节点分布情况
        // 创建队列进行辅助层序遍历二叉树
        // 注意queue是一个接口，不能直接new接口只能new一个实现该接口的类，就是LinkedList类
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点入队操作
        queue.offer(root);
        while (true) {
            TreeNode cur = queue.poll();
            // 进行判断，看看队列里边是否还有元素
            if (cur == null) {
                break;
            }
            // 进行访问操作，也就是判断节点分布情况
            if (!level2) {// 如果不是二阶段，也就是阶段一
                // 左右子树都不为空，则要插入队列
                if (cur.left != null && cur.right != null) {
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    // 左边子树是空的但是右边子树不是空的，返回false
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    // 插入不为空的子树，并进入第二阶段
                    queue.offer(cur.left);
                    level2 = true;
                } else {// 左边子树课右边子树都是空的，进入第二阶段
                    level2 = true;
                }
            } else {// 进入二阶段了
                // 下边支持短路求值，要是前边满足直接进入循环了，
                // 要是前边不是空的，就看第二个条件，也就是说永远不可能是两个都不是空
                if (cur.left != null || cur.right != null) {// 表示有一个是空的
                    return false;
                }
            }
        }
        // 要是遍历完成后也没有发现返回false就说明原来的数是一个完全二叉树
        return true;
    }

    // 20.
}

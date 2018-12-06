import java.util.LinkedList;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void in(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            in(root.left);
            in(root.right);
        }
    }

    public static void pre(TreeNode root) {
        if (root != null) {
            pre(root.left);
            System.out.println(root.val);
            pre(root.right);
        }
    }

    public static void back(TreeNode root) {
        if (root != null) {
            back(root.left);
            back(root.right);
            System.out.println(root.val);
        }
    }

    public static void df(TreeNode root) {
        pre(root);
    }

    public static void bf(TreeNode root) {
        LinkedList<TreeNode> trs = new LinkedList<TreeNode>();
        trs.addFirst(root);
        while (!trs.isEmpty()) {
            TreeNode tmp = trs.pollLast();
            System.out.println(tmp.val);
            if (tmp.left != null) {
                trs.addFirst(tmp.left);
            }
            if (tmp.right != null) {
                trs.addFirst(tmp.right);
            }
        }
    }

}
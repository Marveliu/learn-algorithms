import java.util.ArrayList;
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
        if (root == null)
            return;
        LinkedList<TreeNode> trs = new LinkedList<TreeNode>();
        trs.add(root);
        while (!trs.isEmpty()) {
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while (!trs.isEmpty()) {
                TreeNode t = trs.pollFirst();
                if (t != null) {
                    tmp.add(t.left);
                    tmp.add(t.right);
                    System.out.print(t.val);
                    System.out.print(" ");
                }
            }
            System.out.println();
            trs = tmp;
        }
    }

    /**
     * `8,#,9,#,10`,bp
     * 
     * @param s
     * @return
     */
    public static TreeNode getRoot(String s) {
        // check ..
        String[] in = s.split(",");
        if (in.length == 0) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(in[index]));
        stack.addFirst(root);
        while (true) {
            TreeNode tmp = stack.pollLast();
            index++;
            if (index >= in.length)
                break;
            if (!in[index].equals("#")) {
                tmp.left = new TreeNode(Integer.valueOf(in[index]));
                stack.addFirst(tmp.left);
            }
            index++;
            if (index >= in.length)
                break;
            if (!in[index].equals("#")) {
                tmp.right = new TreeNode(Integer.valueOf(in[index]));
                stack.addFirst(tmp.right);
            }
        }
        return root;
    }

    /**
     * 8,8,7,9,2,#,#,#,#,4,7, bf # present leaf
     * 
     * @param s
     */
    public static TreeNode getRoot1(String s) {
        // check ..
        String[] in = s.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(in[0]));
        getRoot1(root, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode getRoot1(TreeNode root, String[] s, int start, int end) {

        if (root == null || start > end) {
            return null;
        }

        int leftIndex = 2 * start + 1;
        int rightIndex = 2 * start + 2;

        if (leftIndex <= end && !s[leftIndex].equals("#")) {
            root.left = new TreeNode(Integer.valueOf(s[leftIndex]));
        }

        if (rightIndex <= end && !s[rightIndex].equals("#")) {
            root.right = new TreeNode(Integer.valueOf(s[rightIndex]));
        }

        if (root != null) {
            getRoot1(root.left, s, leftIndex, s.length - 1);
            getRoot1(root.right, s, rightIndex, s.length - 1);
        }

        return null;
    }

}
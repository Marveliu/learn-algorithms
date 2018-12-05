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
            bf(root.left);
            bf(root.right);
        }
    }

    public static void pre(TreeNode root) {
        if (root != null) {
            bf(root.left);
            System.out.println(root.val);
            bf(root.right);
        }
    }

    public static void back(TreeNode root) {
        if (root != null) {
            bf(root.left);
            bf(root.right);
            System.out.println(root.val); 
        }
    }

    public static void df(TreeNode root) {
        if (root != null) {
            df(root.left);
            df(root.right);
            System.out.println(root.val); 
        }
    }

    public static void bf(TreeNode root) {

    }

}
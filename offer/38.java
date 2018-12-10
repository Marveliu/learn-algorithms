import java.util.*;

// 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
// dfs
public class Solution {

    int max = 0;

    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, 0);
        return max;
    }

    public void dfs(TreeNode root, int n) {
        if (root == null) {
            if (n > max)
                max = n;
            return;
        }
        if (root != null) {
            n++;
            dfs(root.left, n);
            dfs(root.right, n);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            // String in = sc.nextLine();
            // int[] test =
            // Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item->Integer.valueOf(item)).toArray();
            TreeNode root = TreeNode.getRoot(sc.next());
            int res = s.TreeDepth(root);
            System.out.println(res);
        }
    }
}
import java.util.*;

/**
 * 二叉树的深度
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * dfs,深度优先遍历
 * 
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2
 */
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
            TreeNode root = TreeNode.getRoot(sc.next());
            int res = s.TreeDepth(root);
            System.out.println(res);
        }
    }
}
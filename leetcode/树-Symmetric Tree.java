import java.util.*;

/**
 * 101. Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * 判断当前树是否是镜像
 * 思路：dfs，注意镜像是左子树和右子树比
 * 
 */
public class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            if (left != right)
                return false;
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode root = TreeNode.getRoot(StringUtil.nextLineFilter(sc));
            boolean ans = s.isSymmetric(root);
            System.out.println(ans);
        }
    }
}
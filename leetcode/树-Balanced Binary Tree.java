import java.util.*;

/**
 * 110. Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * 
 * 思路：每个节点都其左右子树的高度进行判断，两次dfs
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = dfs(root.left, 0);
        int right = dfs(root.right, 0);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int dfs(TreeNode root, int l) {
        if (root == null)
            return l;
        int left = dfs(root.left, l + 1);
        int right = dfs(root.right, l + 1);
        return Math.max(l, Math.max(left, right));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot1(sc.nextLine());
            System.out.println(s.isBalanced(test));
        }
    }
}

// 1,#,2,#,#,#,1
// false
// Input>>>
// 3,9,20,#,#,15,7
// true
// Input>>>
// 1,2,2,3,3,#,#,4,4
// false
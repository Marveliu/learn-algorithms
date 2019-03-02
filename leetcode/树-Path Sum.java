import java.util.*;

/**
 * 112. Path Sum
 * https://leetcode.com/problems/path-sum/
 * 
 * 获得指定长的树的长度
 * dfs
 */
public class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(sc.nextLine());
            int sum = sc.nextInt();
            System.out.println(s.hasPathSum(test, sum));
        }
    }
}
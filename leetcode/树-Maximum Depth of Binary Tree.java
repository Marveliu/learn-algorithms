import java.util.*;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * 计算树的最大深度
 * 
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int ld = 0, lr = 0;
        ld = maxDepth(root.left);
        lr = maxDepth(root.right);
        return Math.max(ld + 1, lr + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(StringUtil.nextLineFilter(sc));
            int ans = s.maxDepth(test);
            System.out.println(ans);
        }
    }
}
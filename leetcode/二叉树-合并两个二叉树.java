import java.util.*;

/**
 * 617. Merge Two Binary Trees
 * 
 * https://leetcode.com/problems/merge-two-binary-trees/
 * 
 * 合并两个二叉树
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 != null || t2 != null) {
            if (t1 == null) {
                t1 = new TreeNode(t2.val);
            } else {
                t1.val += (t2 == null ? 0 : t2.val);
            }
            t1.left = mergeTrees(t1.left, t2 == null ? null : t2.left);
            t1.right = mergeTrees(t1.right, t2 == null ? null : t2.right);
            return t1;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode t1 = TreeNode.getRoot1(StringUtil.nextLineFilter(sc));
            TreeNode t2 = TreeNode.getRoot1(StringUtil.nextLineFilter(sc));
            TreeNode.bf(s.mergeTrees(t1, t2));
        }
    }
}
import java.util.*;

/**
 * 100. Same Tree
 * https://leetcode.com/problems/same-tree/
 * 
 * 判断两个树是否一样
 * 思路：dfs比较
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == q)
                return true;
            return false;
        }
        if (p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode p = TreeNode.getRoot(StringUtil.nextLineFilter(sc));
            TreeNode q = TreeNode.getRoot(StringUtil.nextLineFilter(sc));
            boolean ans = s.isSameTree(p, q);
            System.out.println(ans);
        }
    }
}
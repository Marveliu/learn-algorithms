import java.util.*;

/**
 * 129. Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * 
 * 思路:dfs
 * 
 */
public class Solution {

    List<Integer> ans = null;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        ans = new ArrayList<>();
        dfs(root, 0);
        int sum = 0;
        for (Integer var : ans) {
            sum += var;
        }
        return sum;
    }

    public void dfs(TreeNode root, int target) {
        if (root.right == null && root.left == null) {
            ans.add(target * 10 + root.val);
            return;
        }
        if (root.left != null)
            dfs(root.left, target * 10 + root.val);
        if (root.right != null)
            dfs(root.right, target * 10 + root.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            TreeNode test = TreeNode.getRoot(in);
            System.out.println(s.sumNumbers(test));
        }
    }
}
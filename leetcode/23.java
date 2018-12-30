import java.util.*;

// 129. Sum Root to Leaf Numbers
// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
// An example is the root-to-leaf path 1->2->3 which represents the number 123.
// Find the total sum of all root-to-leaf numbers.

// 思路:dfs
public class Solution {

    public int sumNumbers(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(ans, "", root);
        int sum = 0;
        for (Integer var : ans) {
            sum += var;
        }
        return sum;
    }

    public void dfs(List<Integer> ans, String sum, TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                dfs(ans, sum + root.val, root.left);
            }
            if (root.right != null) {
                dfs(ans, sum + root.val, root.right);
            }
            if (root.left == null && root.right == null) {
                ans.add(Integer.valueOf(sum + root.val));
            }
        }
        return;
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
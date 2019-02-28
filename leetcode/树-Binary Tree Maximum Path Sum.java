import java.util.*;

/**
 * 124. Binary Tree Maximum Path Sum
 * 
 * 题意：理解开始有点问题，是指整个树可以理解为一个无向图，任意两个点联通的最大路径，其中每一个边只能经过一次
 * 对每一个节点进行dfs，回溯当前层左右子树最大的节点，进行路径的计算
 * 
 * 时间复杂度：o(n^2)
 */
public class Solution {

    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        System.out.println(node.val + " " + maxValue);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            TreeNode test = TreeNode.getRoot(in);
            TreeNode.bf(test);
            System.out.println(TreeNode.getHeight(test, 0));
        }
    }
}

// -10,9,20,#,#,15,7
// 5,4,8,11,#,13,4,7,2,#,#,#,1
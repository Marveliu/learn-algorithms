import java.util.*;

/**
 * 538. Convert BST to Greater Tree
 * 
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 
 * 反过来的中序遍历，维护上一个的节点，进行计算
 * 
 * 时间复杂度：o(n)
 * 空间复杂度：o(1)
 */
public class Solution {

    TreeNode prev = null;

    public TreeNode convertBST(TreeNode root) {
        prev = null;
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.right);
            if (prev != null) {
                root.val += prev.val;
            }
            prev = root;
            dfs(root.left);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            TreeNode root = TreeNode.getRoot1(StringUtil.nextLineFilter(sc));
            s.convertBST(root);
            TreeNode.bf(root);
        }
    }
}
import java.util.*;

// 98. Validate Binary Search Tree
public class Solution {

    // 中序遍历
    // TimeCompexity: o(n)
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isBST(root, null, null);
    }

    public boolean isBST(TreeNode node, Integer lower_limit, Integer upper_limit) {
        if (lower_limit != null && (node.val <= lower_limit)) {
            return false;
        }
        if (upper_limit != null && upper_limit <= node.val) {
            return false;
        }
        boolean left = node.left != null ? isBST(node.left, lower_limit, node.val) : true;
        if (left) {
            boolean right = node.right != null ? isBST(node.right, node.val, upper_limit) : true;
            return right;
        } else {
            return false;
        }
    }

    // Time Complexity: o(n^2)
    // 从根往叶子节点bfs，速度比较慢，可以使用尾递归的方式，优化一下
    // public boolean isValidBST(TreeNode root) {
    // if (root == null) {
    // return true;
    // }
    // if (!inorder(root.left, root.val, true) || !inorder(root.right, root.val,
    // false)) {
    // return false;
    // }
    // return isValidBST(root.right) && isValidBST(root.left);
    // }

    // public boolean inorder(TreeNode root, int target, Boolean isLeft) {
    // if (root == null)
    // return true;
    // if (isLeft) {
    // if (root.val >= target)
    // return false;
    // } else {
    // if (root.val <= target)
    // return false;
    // }
    // return inorder(root.left, target, isLeft) && inorder(root.right, target,
    // isLeft);
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode root = TreeNode.getRoot1(StringUtil.nextLineFilter(sc));
            boolean ans = s.isValidBST(root);
            System.out.println(ans);
        }
    }
}

// 5,1,4,#,#,3,6
// 10,5,15,#,#,6,20
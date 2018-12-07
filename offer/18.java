import java.util.*;

// 操作给定的二叉树，将其变换为源二叉树的镜像。
public class Solution {

    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // test...
    }
}
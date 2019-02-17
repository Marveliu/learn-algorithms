import java.util.*;

/**
 * 二叉树的镜像
 * 思路：dfs
 * 
 * https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011
 */
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
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode root = TreeNode.getRoot1(StringUtil.nextLineFilter(sc));
            s.Mirror(root);
            TreeNode.bf(root);
        }
    }
}
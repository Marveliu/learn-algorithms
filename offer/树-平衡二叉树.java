import java.util.*;

/**
 * 平衡二叉树
 * 分解左右子树，dfs比较左右子树的高度
 * 
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222
 */
public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        int lh = getHeigth(root.left);
        int rh = getHeigth(root.right);
        if (lh > rh + 1 || rh > lh + 1) {
            return false;
        }
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    // 尾递归，获得当前树的最大高度
    public int getHeigth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(getHeigth(root.left) + 1, getHeigth(root.right) + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(sc.nextLine());
            Boolean res = s.IsBalanced_Solution(test);
            System.out.println(res);

        }
    }
}
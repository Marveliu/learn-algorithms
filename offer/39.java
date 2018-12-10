import java.util.*;

// 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
// 分解左右子树，迭代比较左右子树的高度
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

    // 获得当前树的最大高度
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
import java.util.*;

// 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
// 两个递归...
public class Solution {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        TreeNode p1 = root1;
        TreeNode p2 = root2;
        if (root1.val == root2.val && check(p1, p2)) {
            return true;
        }
        return HasSubtree(p1.left, p2) || HasSubtree(p1.right, p2);
    }

    public boolean check(TreeNode root1, TreeNode root2) {
        if (root2 != null) {
            if (root1 != null && root2.val == root1.val) {
                if (check(root1.left, root2.left) && check(root1.right, root2.right)) {
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // TreeNode t1 = TreeNode.getRoot("8,8,7,9,2,#,#,#,#,4,7");
        // TreeNode t2 = TreeNode.getRoot("8,9,2");
        // LogUtil.log(s.HasSubtree(t1, t2));
        // TreeNode.df();

        TreeNode t1 = TreeNode.getRoot("8,#,9,#,10,#");
        TreeNode.df(t1);

    }
}
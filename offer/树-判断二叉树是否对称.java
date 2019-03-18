import java.util.*;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * dfs
 * 
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb
 */
public class Solution {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return isMirror(pRoot.left, pRoot.right);
    }

    boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 != null && t2 != null && t1.val == t2.val) {
            return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode t1 = TreeNode.getRoot(sc.nextLine());
            boolean ans = s.isSymmetrical(t1);
            System.out.println(ans);
        }
    }
}

// 1,2,2
// true
// Input>>>
// 1,2,3
// false
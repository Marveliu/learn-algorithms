import java.util.*;

/**
 * 树的子结构
 * 
 * 思路：遍历root1所有的节点，作为根节点和root2进行比较
 * 比较的过程也是dfs
 * 时间复杂度:o(n*m)
 * 
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88
 */
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
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode t1 = TreeNode.getRoot(StringUtil.nextLineFilter(sc));
            TreeNode.df(t1);
        }
    }
}
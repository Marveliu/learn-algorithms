import java.util.*;

// 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
// 递归，l 为小于当前值之中最大的节点，r为大于当前值最小的节点，root.left指向l,root.right指向r,并且调整时主要l和r的引用
public class Solution {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree != null) {
            Convert(pRootOfTree.left, null, pRootOfTree);
            Convert(pRootOfTree.right, pRootOfTree, null);
        }
        TreeNode p = pRootOfTree;
        if (p == null)
            return pRootOfTree;
        while (p.left != null) {
            p = p.left;
        }
        return p;
    }

    public void Convert(TreeNode root, TreeNode l, TreeNode r) {
        if (root == null)
            return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && l != null) {
            root.left = l;
            l.right = root;
        }
        if (right == null && r != null) {
            root.right = r;
            r.left = root;
        }
        Convert(left, l, root);
        Convert(right, root, r);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input>>>");
        // TreeNode test = TreeNode.getRoot(sc.nextLine());
        TreeNode res = s.Convert(null);
        LogUtil.log(res.val);
        // test...
    }
}

// 2,1,3
// 1
// 4,2,5,1,3
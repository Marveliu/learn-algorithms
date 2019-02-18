import java.util.*;

/**
 * 二叉搜索树的第k个结点
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 * 
 * 思路:中序遍历
 * 
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a
 */
public class Solution {

    // 每次调用都会修改count值，因此需要重置
    int count = 1;
    // 中序遍历
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode left = KthNode(pRoot.left, k);
            if (left != null)
                return left;
            if (count == k) {
                count = 1;
                return pRoot;
            }
            count++;
            TreeNode right = KthNode(pRoot.right, k);
            if (right != null)
                return right;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(sc.nextLine());
            int k = sc.nextInt();
            TreeNode ans = s.KthNode(test, k);
            System.out.println(ans.val);
        }
    }
}
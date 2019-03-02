import java.util.*;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * 通过中序比那里和后序遍历复原树
 * 
 * 思路：bfs 找到左右子树对应的前序和后序数组，进行递归
 * 后序遍历数组最后一个元素为根节点，并根据根节点在前序遍历的位置，确定左右子树，然后进行迭代
 * 
 * 时间复杂度：o(n^2)
 * 
 */
public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) return null;
        if (inorder.length != postorder.length) {
            return null;
        }

        return bfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode bfs(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }
        int rv = postorder[pe];
        int index = 0;
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == rv) {
                break;
            }
            index++;
        }

        TreeNode root = new TreeNode(rv);
        root.left = bfs(inorder, is, is + index - 1, postorder, ps, ps + index - 1);
        root.right = bfs(inorder, is + index + 1, ie, postorder, ps + index, pe - 1);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] inorder = StringUtil.getIntArr(sc);
            int[] postorder = StringUtil.getIntArr(sc);
            TreeNode ans = s.buildTree(inorder, postorder);
            TreeNode.bf(ans);
        }
    }
}

// [9,3,15,20,7]
// [9,15,7,20,3]
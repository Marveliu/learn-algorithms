import java.util.*;

// 106. Construct Binary Tree from Inorder and Postorder Traversal
// 思路：bfs 找到左右子树对应的前序和后序数组，进行递归
// Time Complexity: o(n^2)
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
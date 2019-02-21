import java.util.*;

/**
 * 
 * Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/ 
 * 
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along
 * the shortest path from the root node down to the nearest leaf node.
 * 
 * bfs
 * 
 * 
 */
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<TreeNode> lt = new LinkedList<>();
        lt.add(root);
        int count = 1;
        while (!lt.isEmpty()) {
            LinkedList<TreeNode> ll = new LinkedList<>();
            while (!lt.isEmpty()) {
                TreeNode tmp = lt.pollFirst();
                if (tmp == null)
                    continue;
                if (isLeaf(tmp)) {
                    return count;
                }
                ll.add(tmp.left);
                ll.add(tmp.right);
            }
            lt = ll;
            count++;
        }
        return count;
    }

    public boolean isLeaf(TreeNode t) {
        if (t == null)
            return false;
        if (t.left != null || t.right != null)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(sc.nextLine());
            int ans = s.minDepth(test);
            System.out.println(ans);
        }
    }
}
import java.util.*;
// binary-tree-preorder-traversal
// Given a binary tree, return the preorder traversal of its nodes' values.

// 非递归实现树的前序遍历
public class Solution {

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                // 访问根节点
                ans.add(p.val);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ArrayList<Integer> ans = s.preorderTraversal(TreeNode.getRoot(in));
            for (Integer var : ans) {
                System.out.println(var + " ");
            }
        }
    }
}
import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * 非递归后序遍历
 * 
 */
public class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> nodes = new LinkedList<>();
        TreeNode cur = null;
        TreeNode prev = null;
        nodes.push(root);
        while (!nodes.isEmpty()) {
            cur = nodes.peek();
            // 无左右子节点，并且上个访问的节点是其子节点
            if ((cur.left == null && cur.right == null) || (prev != null && (prev == cur.left || prev == cur.right))) {
                ans.add(cur.val);
                prev = cur;
                nodes.pop();
            } else {
                if (cur.right != null) {
                    nodes.push(cur.right);
                }
                if (cur.left != null) {
                    nodes.push(cur.left);
                }
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
            List<Integer> ans = s.postorderTraversal(TreeNode.getRoot1(in));
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}
// 1,#,2,3
// 1,2,3,4,5,6,7
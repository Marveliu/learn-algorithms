import java.util.*;

/**
 * 144. Binary Tree Preorder Traversal
 * 非递归实现树的前序遍历
 * 
 */
public class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode p = null;
        while (!stack.isEmpty()) {
            p = stack.pop();
            ans.add(p.val);
            if (p.right != null)
                stack.push(p.right);
            if (p.left != null)
                stack.push(p.left);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            List<Integer> ans = s.preorderTraversal(TreeNode.getRoot1(in));
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}
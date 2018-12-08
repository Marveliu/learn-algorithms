import java.util.*;
// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
// bp
public class Solution {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        if (root == null)
            return arr;
        que.addFirst(root);
        while (!que.isEmpty()) {
            TreeNode tmp = que.pollLast();
            arr.add(tmp.val);
            if (tmp.left != null)
                que.addFirst(tmp.left);
            if (tmp.right != null)
                que.addFirst(tmp.right);
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        LogUtil.log(s.PrintFromTopToBottom(TreeNode.getRoot("10,6,14,4,8,12,16")));
        // test...
    }
}
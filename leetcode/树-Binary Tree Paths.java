import java.util.*;

/**
 * 257. Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * dfs
 */
public class Solution {

    List<String> ans = null;
    
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root,"");
        return ans;
    }
    
    public void dfs(TreeNode root, String s){
        if(root.left == null && root.right == null){
            s += root.val;
            ans.add(s);
            return;
        }
        String ns = s + root.val + "->";
        if(root.left != null) dfs(root.left,ns);
        if(root.right != null) dfs(root.right,ns);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(Arrays.toString(s.binaryTreePaths(TreeNode.getRoot1(sc.nextLine())).toArray()));
        }
    }
}
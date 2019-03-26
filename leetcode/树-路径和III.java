import java.util.*;

/**
 * 437. Path Sum III
 * 
 * https://leetcode.com/problems/path-sum-iii/
 * 
 * 求树的路径和，任意节点即可，但是节点间需要满足上下的关系
 * 
 * dfs
 * 
 */
public class Solution {

    int ans = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        ans = 0;
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                TreeNode cur = nodes.get(i);
                dfs(cur, 0, sum);
                if (cur.left != null)
                    tmp.add(cur.left);
                if (cur.right != null)
                    tmp.add(cur.right);
            }
            nodes = tmp;
        }
        return ans;
    }

    public void dfs(TreeNode root, int sum, int target) {
        if (root != null) {
            sum += root.val;
            if (sum == target) {
                ans++;
            }
            dfs(root.left, sum, target);
            dfs(root.right, sum, target);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            TreeNode root = TreeNode.getRoot1(sc.nextLine());
            int sum = sc.nextInt();
            sc.nextLine();
            System.out.println(s.pathSum(root, sum));
        }
    }
}
import java.util.*;

// 113. Path Sum II
// 思路：dfs
public class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans.clear();
        dfs(root, sum, new ArrayList<>());
        return ans;
    }

    public void dfs(TreeNode root, int sum, List<Integer> path) {
        if (root == null || sum < 0) {
            return;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            path.add(root.val);
            ans.add(path);
            return;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        left.addAll(path);
        left.add(root.val);
        right.addAll(path);
        right.add(root.val);

        dfs(root.left, sum - root.val, left);
        dfs(root.right, sum - root.val, right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(sc.nextLine());
            int sum = sc.nextInt();
            List<List<Integer>> ans = s.pathSum(test, sum);
            for (List<Integer> var : ans) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
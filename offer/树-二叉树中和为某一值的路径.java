import java.util.*;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 
 * dfs
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca
 */
public class Solution {

    ArrayList<ArrayList<Integer>> res;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        // bfs
        res = new ArrayList<ArrayList<Integer>>();
        List<TreeNode> list = new ArrayList<>();
        if (root != null)
            list.add(root);
        while (!list.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode var : list) {
                dfs(new ArrayList<>(), var, target);
                if (var.left != null)
                    tmp.add(var.left);
                if (var.right != null)
                    tmp.add(var.right);
            }
            list = tmp;
        }
        return res;
    }

    public void dfs(ArrayList<Integer> arr, TreeNode root, int target) {
        if (root == null)
            return;
        arr.add(root.val);
        target = target - root.val;
        if (target < 0) {
            return;
        }
        if (target == 0 && root.left == null && root.right == null) {
            res.add(arr);
            return;
        }
        dfs(new ArrayList<>(arr), root.left, target);
        dfs(new ArrayList<>(arr), root.right, target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            for (ArrayList<Integer> arr : s.FindPath(TreeNode.getRoot1(StringUtil.nextLineFilter(sc)), sc.nextInt())) {
                System.out.println(Arrays.toString(arr.toArray()));
            }
        }
    }
}
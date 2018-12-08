import java.util.*;

public class Solution {

    // 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
    // 
    // dfs 
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root != null) {
            ArrayList<Integer> arr = new ArrayList<>();
            dfs(arr, root, target);
            FindPath(root.left, target);
            FindPath(root.right, target);
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
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (Integer item : arr) {
            left.add(item);
            right.add(item);
        }
        dfs(left, root.left, target);
        dfs(right, root.right, target);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = TreeNode.getRoot("1,2,2,3");
        ArrayList<ArrayList<Integer>> res = s.FindPath(root, 10);
        for (ArrayList<Integer> arr : res) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
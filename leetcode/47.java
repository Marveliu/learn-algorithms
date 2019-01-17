import java.util.*;

// 107.Binary Tree Level Order Traversal II
// 思路：BFS,stack进行顺序反转
// Time Complexity: o(n)
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<List<Integer>> stack = new ArrayDeque<>();
        ArrayList<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            ArrayList<TreeNode> tmp = new ArrayList<>();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < nodes.size(); i++) {
                TreeNode now = nodes.get(i);
                item.add(now.val);
                if (now.left != null)
                    tmp.add(now.left);
                if (now.right != null)
                    tmp.add(now.right);
            }
            stack.push(item);
            nodes = tmp;
        }
        while (!stack.isEmpty()) {
            ans.add(stack.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(StringUtil.nextLineFilter(sc));
            List<List<Integer>> ans = s.levelOrderBottom(test);
            for (List<Integer> var : ans) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}

// 3,9,20,#,#,15,7
// [15, 7]
// [9, 20]
// [3]
// Input>>>
// ,
// Input>>>
// 1
// [1]
// Input>>>
// 1,2,3
// [2, 3]
// [1]
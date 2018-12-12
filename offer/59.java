import java.util.*;
// 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
// bfs
public class Solution {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        LinkedList<TreeNode> st = new LinkedList<>();
        if (pRoot == null)
            return ans;
        st.add(pRoot);
        while (!st.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<>();
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while (!st.isEmpty()) {
                TreeNode t = st.pollLast();
                if (t != null) {
                    arr.add(t.val);
                    tmp.push(t.left);
                    tmp.push(t.right);
                }
            }
            if (arr.size() != 0)
                ans.add(arr);
            st = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(sc.nextLine());
            ArrayList<ArrayList<Integer>> ans = s.Print(test);
            for (ArrayList<Integer> var : ans) {
                for (int i = 0; i < var.size(); i++) {
                    System.out.print(var.get(i));
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
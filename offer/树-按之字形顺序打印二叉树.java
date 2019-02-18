import java.util.*;

/**
 * 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * bfs
 * 
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0
 */
public class Solution {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (pRoot == null)
            return ans;
        st.push(pRoot);
        boolean lr = true;
        while (!st.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<>();
            Stack<TreeNode> tmp = new Stack<>();
            while (!st.isEmpty()) {
                TreeNode t = st.pop();
                if (t != null) {
                    arr.add(t.val);
                    if (lr) {
                        tmp.push(t.left);
                        tmp.push(t.right);
                    } else {
                        tmp.push(t.right);
                        tmp.push(t.left);
                    }
                }
            }
            lr = (lr == true ? false : true);
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
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
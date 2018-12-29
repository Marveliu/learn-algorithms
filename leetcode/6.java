import java.util.*;
// Binary Tree Postorder Traversal
// 
// 后序排序特点，最后一位是根节点，前半部分是左子树，后半部分是右子树
// 可以直接
public class Solution {

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<TreeNode> tls = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        tls.add(root);
        // int index = 0;
        // while (index < tls.size()) {
        // int i = 0;
        // TreeNode tmp = tls.get(index);
        // if (tmp.right != null) {
        // i++;
        // tls.add(index + i, tmp.right);
        // }
        // if (tmp.left != null) {
        // i++;
        // tls.add(index + i, tmp.left);
        // }
        // index++;
        // }

        ListIterator<TreeNode> ltr = tls.listIterator();
        while (ltr.hasNext()) {
            int i = 0;
            TreeNode tmp = ltr.next();
            System.out.println(tmp.val);
            if (tmp.right != null) {
                ltr.add(tmp.right);
                i++;
            }
            if (tmp.left != null) {
                ltr.add(tmp.left);
                i++;
            }
            while (i > 0) {
                ltr.previous();
                i--;
            }
        }

        for (int i = tls.size() - 1; i >= 0; i--) {
            ans.add(tls.get(i).val);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ArrayList<Integer> ans = s.postorderTraversal(TreeNode.getRoot(in));
            System.out.println();
            for (Integer var : ans) {
                System.out.println(var + " ");
            }
        }
    }
}
// 1,#,2,3
// 1,2,3,4,5,6,7
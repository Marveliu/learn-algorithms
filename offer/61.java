import java.util.*;

// 请实现两个函数，分别用来序列化和反序列化二叉树

// bps 与逆bps # 表示为空
// todo:前序遍历更快
public class Solution {

    String Serialize(TreeNode root) {
        if (root == null)
            return null;
        LinkedList<TreeNode> lt = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        lt.add(root);
        while (!lt.isEmpty()) {
            TreeNode t = lt.pollFirst();
            if (t != null) {
                lt.add(t.left);
                lt.add(t.right);
                sb.append(t.val);
            } else {
                sb.append("#");
            }
            sb.append(",");
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if (str == null)
            return null;
        String[] in = str.split(",");
        if (in.length == 0) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(in[index]));
        stack.addFirst(root);
        while (true) {
            TreeNode tmp = stack.pollLast();
            index++;
            if (index >= in.length)
                break;
            if (!in[index].equals("#")) {
                tmp.left = new TreeNode(Integer.valueOf(in[index]));
                stack.addFirst(tmp.left);
            }
            index++;
            if (index >= in.length)
                break;
            if (!in[index].equals("#")) {
                tmp.right = new TreeNode(Integer.valueOf(in[index]));
                stack.addFirst(tmp.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode test = TreeNode.getRoot(sc.nextLine());
            String ser = s.Serialize(test);
            System.out.println("serialize:");
            System.out.println(ser);
            TreeNode ans = s.Deserialize(ser);
            TreeNode.bf(ans);
        }
    }
}
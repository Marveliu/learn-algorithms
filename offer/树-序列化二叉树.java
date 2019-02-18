import java.util.*;
/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 思路:bfs与逆bfs #表示为空
 * 
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84
 */
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
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(in[index]));
        queue.addFirst(root);
        while (true) {
            TreeNode tmp = queue.pollLast();
            index++;
            if (index >= in.length)
                break;
            if (!in[index].equals("#")) {
                tmp.left = new TreeNode(Integer.valueOf(in[index]));
                queue.addFirst(tmp.left);
            }
            index++;
            if (index >= in.length)
                break;
            if (!in[index].equals("#")) {
                tmp.right = new TreeNode(Integer.valueOf(in[index]));
                queue.addFirst(tmp.right);
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
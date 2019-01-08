import java.util.*;

// 116. Populating Next Right Pointers in Each Node
// 思路：模拟
// Time Complexity: o(2*n)
public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        TreeLinkNode t1 = root;
        TreeLinkNode t2 = root.left;
        while (t2 != null) {
            TreeLinkNode tmp1 = t1;
            TreeLinkNode tmp2 = t2;
            while (tmp1 != null) {
                tmp2.next = tmp1.right;
                tmp2 = tmp2.next;
                if (tmp1.next != null) {
                    tmp2.next = tmp1.next.left;
                    tmp2 = tmp2.next;
                }
                tmp1 = tmp1.next;
            }
            t1 = t1.left;
            t2 = t2.left;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            TreeLinkNode root = new TreeLinkNode(test[0]);
            ArrayList<TreeLinkNode> arr = new ArrayList<>();
            arr.add(root);
            for (int i = 0; 2 * i + 1 < test.length; i++) {
                TreeLinkNode tmp = arr.get(i);
                tmp.left = new TreeLinkNode(test[2 * i + 1]);
                tmp.right = new TreeLinkNode(test[2 * i + 2]);
                arr.add(tmp.left);
                arr.add(tmp.right);
            }
            // bfs
            TreeLinkNode t = root;
            ArrayList<TreeLinkNode> queue = new ArrayList<>();
            queue.add(t);
            while (!queue.isEmpty()) {
                ArrayList<TreeLinkNode> tmp = new ArrayList<>();
                for (int i = 0; i < queue.size(); i++) {
                    TreeLinkNode now = queue.get(i);
                    System.out.print(now.val + " ");
                    if (now.left != null)
                        tmp.add(now.left);
                    if (now.right != null)
                        tmp.add(now.right);
                }
                System.out.println();
                queue = tmp;
            }

            s.connect(arr.get(0));
            TreeLinkNode t1 = root;
            while (t1 != null) {
                TreeLinkNode tmp = t1;
                while (tmp != null) {
                    System.out.print(tmp.val + " ");
                    tmp = tmp.next;
                }
                System.out.println();
                t1 = t1.left;
            }

        }
    }
}

import java.util.*;

/**
 * 116. Populating Next Right Pointers in Each Node
 * 117. Populating Next Right Pointers in Each Node II
 * 
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * 思路：bfs
 * 
 */
public class Solution {

    public Node connect(Node root) {
        if (root == null)
            return root;
        List<Node> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Node> tmp = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Node next = (i + 1 < list.size() ? list.get(i + 1) : null);
                Node now = list.get(i);
                now.next = next;
                if (now.left != null)
                    tmp.add(now.left);
                if (now.right != null)
                    tmp.add(now.right);
            }
            list = tmp;
        }
        return root;
    }
}

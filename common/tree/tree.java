import java.util.*;

// 树的前中后序比遍历
// 递归与非递归实现
class tree {

    public void prev(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode pop = nodes.pop();
            System.out.print(pop.val + " ");
            if (pop.right != null) {
                nodes.push(pop.right);
            }
            if (pop.left != null) {
                nodes.push(pop.left);
            }
        }
    }

    public void in(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        TreeNode p = root;
        p = root;
        while (p != null || !nodes.isEmpty()) {
            // 找到所有的子节点
            while (p != null) {
                nodes.push(p);
                p = p.left;
            }
            if (!nodes.isEmpty()) {
                p = nodes.pop();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
    }

    public void back(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        TreeNode cur = null;
        TreeNode prev = null;
        nodes.push(root);
        while (!nodes.isEmpty()) {
            cur = nodes.peek();
            // 无左右子节点，并且上个访问的节点是其子节点
            if ((cur.left == null && cur.right == null) || (prev != null && (prev == cur.left || prev == cur.right))) {
                System.out.print(cur.val + " ");
                prev = cur;
                nodes.pop();
            } else {
                if (cur.right != null) {
                    nodes.push(cur.right);
                }
                if (cur.left != null) {
                    nodes.push(cur.left);
                }
            }
        }
    }

    public void prevdfs(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            prevdfs(root.left);
            prevdfs(root.right);
        }
    }

    public void indfs(TreeNode root) {
        if (root != null) {
            indfs(root.left);
            System.out.print(root.val + " ");
            indfs(root.right);
        }
    }

    public void backdfs(TreeNode root) {
        if (root != null) {
            backdfs(root.left);
            backdfs(root.right);
            System.out.print(root.val + " ");
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String line = StringUtil.nextLineFilter(sc);
            s.prev(TreeNode.getRoot1(line));
            System.out.println();
            s.prevdfs(TreeNode.getRoot1(line));
            s.in(TreeNode.getRoot1(line));
            System.out.println();
            s.indfs(TreeNode.getRoot1(line));
            s.back(TreeNode.getRoot1(line));
            System.out.println();
            s.backdfs(TreeNode.getRoot1(line));
        }
    }
}
import java.util.*;

import apple.laf.JRSUIUtils.Tree;

// 99. Recover Binary Search Tree

public class Solution {

    // 思路：和第二种方法相比，直接在中序遍历的过程之中，找到了两个节点，但是空间复杂度更低
    // 参考：https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null)
            return;
        traverse(root.left);
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;
        traverse(root.right);
    }

    // 思路：中序遍历获得引用数组，找到异常的两个点，进行值的交换
    // Time Complexity: o(n)
    // Space Complexity: o(n)
    // ArrayList<TreeNode> nodes = new ArrayList<>();
    // public void recoverTree(TreeNode root) {
    // nodes.clear();
    // inoder(root);
    // int i1 = -1;
    // int i2 = -1;
    // for (int i = 0; i < nodes.size(); i++) {
    // int now = nodes.get(i).val;
    // int prev = (i - 1 < 0) ? Integer.MIN_VALUE : nodes.get(i - 1).val;
    // int next = (i + 1 >= nodes.size()) ? Integer.MAX_VALUE : nodes.get(i +
    // 1).val;
    // if (now < prev || now > next) {
    // if (i1 == -1) {
    // i1 = i;
    // } else {
    // i2 = i;
    // }
    // }
    // }
    // // swap
    // TreeNode t1 = nodes.get(i1);
    // TreeNode t2 = nodes.get(i2);
    // int tmp = t2.val;
    // t2.val = t1.val;
    // t1.val = tmp;
    // }

    // public void inoder(TreeNode root) {
    // if (root == null)
    // return;
    // inoder(root.left);
    // nodes.add(root);
    // inoder(root.right);
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            TreeNode root = TreeNode.getRoot1(StringUtil.nextLineFilter(sc));
            s.recoverTree(root);
            TreeNode.in(root);
        }
    }
}
import java.util.*;
import java.util.stream.Collectors;

// 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
// SubList只是返回了List的一个视图，并且要主要from, to中的to所在的位置
// 该题必须是要理解树的遍历，然后牛客网的关于树的输出以一般是广度优先遍历

public class Solution {

    // 1.
    // public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    // int len = pre.length;
    // if (len == 0) {
    // return null;
    // }
    // int root = pre[0];
    // TreeNode parent = new TreeNode(root);
    // List<Integer> p = Arrays.stream(pre).boxed().collect(Collectors.toList());
    // List<Integer> i = Arrays.stream(in).boxed().collect(Collectors.toList());
    // reConstruct(p, i, parent);
    // return parent;
    // }

    // 2. 直接对数组操作，选好迭代的点
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return reConstruct(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstruct(int[] p, int sp, int ep, int[] i, int si, int ei) {
        if (sp > ep || si > ei) {
            return null;
        }
        TreeNode root = new TreeNode(p[sp]);
        for (int index = si; index <= ei; index++) {
            if (i[index] == p[sp]) {
                root.left = reConstruct(p, sp + 1, index - si + sp, i, si, index - 1);
                root.right = reConstruct(p, index - si + sp + 1, ep, i, index + 1, ei);
            }
        }
        return root;
    }

    public void reConstructLeft(List<Integer> pre, List<Integer> in, TreeNode parent) {
        if (pre.size() != 0) {
            parent.left = new TreeNode(pre.get(0));
            reConstruct(pre, in, parent.left);
        }
    }

    public void reConstructRight(List<Integer> pre, List<Integer> in, TreeNode parent) {
        if (pre.size() != 0) {
            parent.right = new TreeNode(pre.get(0));
            reConstruct(pre, in, parent.right);
        }
    }

    public void reConstruct(List<Integer> p, List<Integer> i, TreeNode parent) {
        int len = p.size();
        if (len == 1)
            return;
        int index = i.indexOf(parent.val);
        if (index == 0) {
            reConstructRight(p.subList(1, len), i.subList(index + 1, len), parent);
        } else if (index == len - 1) {
            reConstructLeft(p.subList(1, len), i.subList(0, index), parent);
        } else {
            reConstructLeft(p.subList(1, index + 1), i.subList(0, index), parent);
            reConstructRight(p.subList(index + 1, len), i.subList(index + 1, len), parent);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pre = { 1, 2, 3, 4, 5, 6, 7 };
        int[] in = { 3, 2, 4, 1, 6, 5, 7 };
        // int[] pre = { 1, 2, 3 };
        // int[] in = { 3, 2, 1 };
        TreeNode head = s.reConstructBinaryTree(pre, in);
        TreeNode.bf(head);
        // test...
    }
}

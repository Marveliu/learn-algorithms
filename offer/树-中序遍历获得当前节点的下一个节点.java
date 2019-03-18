import java.util.*;

/**
 * 二叉树的下一个结点
 * 
 * 请找出中序遍历顺序的下一个结点并且返回
 * 
 * 三种情况：
 * 1. 有右节点，寻找右节点的最左节点
 * 2. 有父节点
 * 2.1 当前节点是父节点的右节点，寻找父节点的父节点，且父节点是该节点的左孩子
 * 2.2 当前节点是父节点的左节点，直接返回
 * 
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e
 */
public class Solution {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode ans = null;
        if (pNode.right != null) {
            ans = pNode.right;
            while (ans.left != null) {
                ans = ans.left;
            }
            return ans;
        }
        if (pNode.next != null && pNode.next.right == pNode){
            ans = pNode.next;
            while (ans.next != null && ans.next.left == ans) {
                ans = ans.next;
            }
            return ans.right == pNode ? null : ans;
        }
        if (pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }
        return null;
    }
        
    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
        }
    }
}

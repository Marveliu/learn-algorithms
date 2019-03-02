import java.util.*;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * 思路：快慢指针，找到根节点，对左右进行递归
 * 时间复杂度：o(nlogn)
 * 
 */
public class Solution {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail) {
            return null;
        }
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode test = ListNode.getHead(StringUtil.nextLineFilter(sc));
            TreeNode ans = s.sortedListToBST(test);
            TreeNode.bf(ans);
        }
    }
}

// [-10,-3,0,5,9]
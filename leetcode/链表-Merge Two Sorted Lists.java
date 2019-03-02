import java.util.*;

/**
 * 21. Merge Two Sorted Lists
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = root;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                head.next = p1;
                p1 = p1.next;
            } else {
                head.next = p2;
                p2 = p2.next;
            }
            head = head.next;
        }
        head.next = (p1 == null ? p2 : p1);
        return root.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode l1 = ListNode.getHead(StringUtil.nextLineFilter(sc));
            ListNode l2 = ListNode.getHead(StringUtil.nextLineFilter(sc));
            ListNode.log(s.mergeTwoLists(l1, l2));
        }
    }
}
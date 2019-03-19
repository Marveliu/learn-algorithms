import java.util.*;

/**
 * 2. Add Two Numbers
 * 
 * 链表相加
 * 
 * https://leetcode.com/problems/add-two-numbers/
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode p1 = l1, p2 = l2;
        ListNode root = new ListNode(0);
        ListNode p = root;
        while (p1 != null || p2 != null) {
            int tmp = (p1 == null ? 0 : p1.val) + (p2 == null ? 0 : p2.val) + carry;
            carry = tmp / 10;
            int val = tmp % 10;
            ListNode node = new ListNode(val);
            p.next = node;
            p = node;
            p1 = (p1 == null ? null : p1.next);
            p2 = (p2 == null ? null : p2.next);
        }
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            p.next = node;
            p = node;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode l1 = ListNode.getHead(StringUtil.nextLineFilter(sc));
            ListNode l2 = ListNode.getHead(StringUtil.nextLineFilter(sc));
            ListNode.log(s.addTwoNumbers(l1, l2));
        }
    }
}
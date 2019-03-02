import java.util.*;

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 对链表中间一段进行反转
 * 时间复杂度：o(n) 
 */
public class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return null;
        ListNode root = new ListNode(0);
        root.next = head;
        int i = -1;
        ListNode p = root;
        ListNode rHead = null;
        ListNode rTail = null;
        ListNode end = null;

        while (p != null) {
            i++;
            if (i == m - 1) {
                rHead = p;
                rTail = p.next;
                p = rTail;
                rHead.next = null;
                continue;
            }
            if (i >= m && i <= n) {
                if (i == m) {
                    end = p;
                }
                rTail = p.next;
                p.next = rHead.next;
                rHead.next = p;
                p = rTail;
                continue;
            }

            if (i > n) {
                end.next = rTail;
                break;
            }
            p = p.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ListNode test = ListNode.getHead(in);
            int m = sc.nextInt();
            sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();
            ListNode ans = s.reverseBetween(test, m, n);
            ListNode.log(ans);
        }
    }
}
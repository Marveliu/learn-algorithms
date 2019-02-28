import java.util.*;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 * 链表判环
 */
public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        do {
            if (quick == null || quick.next == null)
                return false;
            slow = slow.next;
            quick = quick.next.next;
        } while (slow != quick);
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
        }
    }
}
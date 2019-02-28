import java.util.*;



/**
 * 142. Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 * 快慢指针
 * 
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        do {
            if (quick == null || quick.next == null)
                return null;
            slow = slow.next;
            quick = quick.next.next;
        } while (quick != slow);
        slow = head;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ListNode test = ListNode.getHead(in);
            int p = sc.nextInt();
            if (p >= 0) {
                ListNode pos = test;
                ListNode tail = test;
                while (tail.next != null) {
                    tail = tail.next;
                }
                while (p != 0) {
                    pos = pos.next;
                    p--;
                }
                tail.next = pos;
            }
            ListNode ans = s.detectCycle(test);
            if (ans == null) {
                System.out.println("no circle!");
            } else {
                System.out.println(ans.val);
            }
        }
    }
}
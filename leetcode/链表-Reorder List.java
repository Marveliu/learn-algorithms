import java.util.*;

/**
 * 143. Reorder List
 * 
 * https://leetcode.com/problems/reorder-list/
 * 
 * 快慢指针进行切割
 * 第二段链表反转
 * 然后进行链表合并
 * 
 */
public class Solution {

    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        if (slow == quick)
            return;
        // reverse
        ListNode h1 = slow.next;
        slow.next = null;
        ListNode p = h1.next;
        h1.next = null;
        while (p != null) {
            ListNode tmp = p.next;
            p.next = h1;
            h1 = p;
            p = tmp;
        }
        // merge
        ListNode root = new ListNode(0);
        p = root;
        ListNode p1 = head;
        ListNode p2 = h1;
        while (p1 != null && p2 != null) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        p.next = (p1 != null ? p1 : p2);
        head = root.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ListNode test = ListNode.getHead(in);
            s.reorderList(test);
            ListNode.log(test);
        }
    }
}

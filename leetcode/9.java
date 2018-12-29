import java.util.*;
// reorder list
// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
// You may not modify the values in the list's nodes, only nodes itself may be changed.
// 快慢指针进行切割，链表反转，然后进行链表合并
public class Solution {

    public void reorderList(ListNode head) {
        if(head == null) return;

        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode tmp = head;
        ListNode p1 = head.next;
        ListNode p2 = slow.next;
        slow.next = null;

        // reverse
        ListNode p3 = new ListNode(0);
        while (p2 != null) {
            ListNode node = p2.next;
            p2.next = p3.next;
            p3.next = p2;
            p2 = node;
        }
        p2 = p3.next;

        boolean flag = true;
        while (p1 != null && p2 != null) {
            if (flag) {
                tmp.next = p2;
                p2 = p2.next;
                flag = false;
            } else {
                tmp.next = p1;
                p1 = p1.next;
                flag = true;
            }
            tmp = tmp.next;
        }
        if (p1 != null) {
            tmp.next = p1;
        }
        if (p2 != null) {
            tmp.next = p2;
        }
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

import java.util.*;
// Sort a linked list in O(n log n) time using constant space complexity.
// O(n log n )可以考虑归并排序
// 快慢指针对链表进行切割，注意切割点next置为null，否则可能导致环
// 由于要固定的空间大小，所以是对原来的节点进行顺序调整。

public class Solution {

    // 归并排序
    public ListNode sortList(ListNode head) {
        return merge(head, null);
    }

    public ListNode merge(ListNode start, ListNode end) {
        if (start == end) {
            return start;
        }
        ListNode slow = start;
        ListNode quick = start;
        while (quick != null && quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }

        ListNode index = slow.next;
        slow.next = null;
        ListNode h1 = merge(start, slow);
        ListNode h2 = merge(index, end);

        ListNode root = new ListNode(Integer.MIN_VALUE);
        ListNode tmp = root;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                tmp.next = h1;
                h1 = h1.next;
            } else {
                tmp.next = h2;
                h2 = h2.next;
            }
            tmp = tmp.next;
        }
        if (h1 != null)
            tmp.next = h1;
        if (h2 != null)
            tmp.next = h2;
        return root.next;
    }

    // 超时
    // public ListNode sortList(ListNode head) {
    // ListNode root = new ListNode(Integer.MIN_VALUE);
    // root.next = head;
    // ListNode prev = root;
    // ListNode next = head;
    // ListNode tmp = head;
    // while (tmp != null) {
    // while (next != null && next != tmp) {
    // // find
    // if (next.val > tmp.val) {
    // break;
    // }
    // prev = next;
    // next = next.next;
    // }
    // ListNode p = tmp.next;
    // if (next == tmp) {
    // tmp.next = null;
    // }
    // // swap
    // if (tmp != prev && tmp != next) {
    // tmp.next = prev.next;
    // prev.next = tmp;
    // }
    // prev = root;
    // next = root.next;
    // tmp = p;
    // }
    // return root.next;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ListNode head = ListNode.getHead(in);
            ListNode.log(s.sortList(head));
        }
    }
}
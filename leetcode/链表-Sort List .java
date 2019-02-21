import java.util.*;
/**
 * 148. Sort List 
 * https://leetcode.com/problems/sort-list/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * 思路:快排或者归并排序,使用快慢指针。
 * 
 */
public class Solution {

    // public ListNode sortList(ListNode head) {
    // return mergeSort(head);
    // }

    // public ListNode mergeSort(ListNode start) {
    // if (start == null || start.next == null) {
    // return start;
    // }
    // ListNode slow = start;
    // ListNode quick = start;
    // // 快慢指针
    // while (quick != null && quick.next != null && quick.next.next != null) {
    // slow = slow.next;
    // quick = quick.next.next;
    // }
    // ListNode index = slow.next;
    // slow.next = null;
    // ListNode h1 = mergeSort(start);
    // ListNode h2 = mergeSort(index);
    // int cmp = h1.val - h2.val;
    // ListNode root = (cmp < 0 ? h1 : h2);
    // h1 = (cmp < 0 ? h1.next : h1);
    // h2 = (cmp < 0 ? h2 : h2.next);
    // ListNode p = root;
    // // 链表比较并合并
    // while (h1 != null && h2 != null) {
    // if (h1.val < h2.val) {
    // p.next = h1;
    // h1 = h1.next;
    // } else {
    // p.next = h2;
    // h2 = h2.next;
    // }
    // p = p.next;
    // }
    // p.next = (h1 == null ? h2 : h1);
    // return root;
    // }

    public ListNode sortList(ListNode head) {
        quickSort(head, null);
        return head;
    }

    public void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partition(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public ListNode partition(ListNode head, ListNode end) {
        
        ListNode p1 = head, p2 = head.next;
        while (p2 != end) {
            if (p2.val < head.val) {
                p1 = p1.next;
                // swap p1 p2
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }

        if (p1 != head) {
            int tmp = p1.val;
            p1.val = head.val;
            head.val = tmp;
        }
        return p1;
    }

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
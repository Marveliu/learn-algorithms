import java.util.*;

/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * 思路：多路链表归并排序
 * 
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    public ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start >= end)
            return lists[start];
        int mid = (start + end) / 2;
        ListNode h1 = mergeSort(lists, start, mid);
        ListNode h2 = mergeSort(lists, mid + 1, end);
        ListNode merge = merge(h1, h2);
        return merge;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode p1 = a;
        ListNode p2 = b;
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        p.next = (p1 != null ? p1 : p2);
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            sc.nextLine();
            ListNode[] lists = new ListNode[n];
            for (int i = 0; i < n; i++) {
                lists[i] = ListNode.getHead(StringUtil.nextLineFilter(sc));
            }
            ListNode.log(s.mergeKLists(lists));
        }
    }
}

// 3
// 1,4,5
// 1,3,4
// 2,6
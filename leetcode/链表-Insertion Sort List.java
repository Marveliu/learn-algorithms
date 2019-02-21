import java.util.*;

/**
 * 147. Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/
 * 
 * 思路:插入排序，需要一个辅助节点
 */
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        // new starter of the sorted list
        ListNode helper = new ListNode(0);
        // the node will be inserted
        ListNode cur = head;
        // insert node between pre and pre.next
        ListNode pre = helper;
        // the next node will be inserted
        ListNode next = null;
        // not the end of input list
        while (cur != null) {
            next = cur.next;
            // find the right place to insert
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            // insert between pre and pre.next
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }

        return helper.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ListNode.log(s.insertionSortList(ListNode.getHead(in)));
        }
    }
}
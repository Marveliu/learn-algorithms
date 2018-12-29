import java.util.*;
// Sort a linked list using insertion sort.
// 链表插入排序
public class Solution {

    public ListNode insertionSortList(ListNode head) {
        ListNode root = new ListNode(Integer.MIN_VALUE);
        root.next = head;
        ListNode prev = root;
        ListNode next = head;
        ListNode tmp = head;
        while (tmp != null) {
            while (next != null && next != tmp) {
                if (next.val > tmp.val) {
                    break;
                }
                next = next.next;
                prev = prev.next;
            }
            // swap
            ListNode p = tmp.next;
            if (next == tmp) {
                tmp.next = null;
            } else {
                tmp.next = prev.next;
                prev.next = tmp;
            }
            prev = root;
            next = root.next;
            tmp = p;
        }
        return root.next;
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
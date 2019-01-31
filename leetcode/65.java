import java.util.*;

// 83. Remove Duplicates from Sorted List
// 思路：模拟
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        int last = Integer.MIN_VALUE;
        ListNode p = head;
        ListNode prev = new ListNode(0);
        prev.next = p;
        while (p != null) {
            if (p.val == last) {
                prev.next = p.next;
            } else {
                prev = p;
            }
            last = Math.max(p.val, last);
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode head = ListNode.getHead(StringUtil.nextLineFilter(sc));
            ListNode ans = s.deleteDuplicates(head);
            ListNode.log(ans);
        }
    }
}
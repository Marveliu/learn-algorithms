import java.util.*;
// 输入一个链表，反转链表后，输出新链表的表头。
public class Solution {

    // impl...
    public ListNode ReverseList(ListNode head) {
        ListNode res = head;
        if (head == null)
            return res;
        ListNode point = head.next;
        res.next = null;
        while (point != null) {
            ListNode tmp = null;
            // if (point.next.next != null) {
            // tmp = point.next.next;
            // }
            tmp = point.next;
            point.next = res;
            res = point;
            point = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.getHead("1,2,3,4,5,9");
        ListNode.log(s.ReverseList(head));
        // test...
    }
}
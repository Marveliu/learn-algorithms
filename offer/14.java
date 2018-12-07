import java.util.*;
// 输入一个链表，输出该链表中倒数第k个结点。

public class Solution {

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode tmp = head;
        ListNode res = head;
        while (tmp != null) {
            if (k != 0) {
                k--;
            } else {
                res = res.next;
            }
            tmp = tmp.next;
        }
        if (k != 0) {
            return null;
        }
        return res;
    }
    // impl...

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.getHead("1,2,3,4,5");
        LogUtil.log(s.FindKthToTail(head, 9).val);
        // test...
    }
}
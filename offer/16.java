import java.util.*;
// 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

// 递归，每个递归体计算下个节点
public class Solution {

    ListNode root = new ListNode(0);
    ListNode end = root;

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p1 = null;
        ListNode p2 = null;

        if (list1 == null) {
            end.next = list2;
        } else if (list2 == null) {
            end.next = list1;
        } else {
            if (list1.val > list2.val) {
                end.next = list2;
                p2 = list2.next;
                p1 = list1;
            } else {
                end.next = list1;
                p1 = list1.next;
                p2 = list2;
            }
            end = end.next;
            Merge(p1, p2);
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode p1 = ListNode.getHead("1,2,3,4");
        ListNode p2 = ListNode.getHead("1,5");
        ListNode.log(s.Merge(p1, p2));

        // test...
    }
}
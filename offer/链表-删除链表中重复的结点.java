import java.util.*;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 
 * 思路:排序链表，前后两个指针进行比较判断
 * 
 * https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef
 */
public class Solution {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return pHead;
        ListNode root = new ListNode(pHead.val - 1);
        root.next = pHead;
        ListNode head = root;
        ListNode prev = head.next;
        ListNode next = prev.next;
        while (next != null) {
            if (next.val == prev.val) {
                while (next != null && next.val == prev.val) {
                    prev.next = next.next;
                    next = prev.next;
                }
                head.next = next;
                prev = next;
                next = (next == null ? null : next.next);
            } else {
                head = head.next;
                prev = prev.next;
                next = next.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ListNode test = ListNode.getHead(in);
            ListNode ans = s.deleteDuplication(test);
            ListNode.log(ans);
        }
    }
}
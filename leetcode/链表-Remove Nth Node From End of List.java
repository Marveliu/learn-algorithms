import java.util.*;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * 双指针+辅助头节点
 */
public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode hepler = new ListNode(0);
        hepler.next = head;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode prev = hepler;
        while (n != 0) {
            p2 = p2.next;
            n--;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
            prev = prev.next;
        }
        prev.next = p1.next;
        p1.next = null;
        return hepler.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode.log(s.removeNthFromEnd(ListNode.getHead(StringUtil.nextLineFilter(sc)), sc.nextInt()));
        }
    }
}
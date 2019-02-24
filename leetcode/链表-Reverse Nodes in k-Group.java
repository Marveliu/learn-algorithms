import java.util.*;

/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * 链表反转+dfs
 */
public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        int len = getLen(head);
        return dfs(head, len, k);
    }

    public ListNode dfs(ListNode head, int len, int k) {
        if (head == null || len < k)
            return head;
        ListNode p = head.next;
        ListNode tail = head;
        head.next = null;
        int count = 0;
        while (p != null && count != k - 1) {
            ListNode tmp = p.next;
            p.next = head;
            head = p;
            p = tmp;
            count++;
        }
        tail.next = dfs(p, len - k, k);
        return head;
    }

    public int getLen(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode.log(s.reverseKGroup(ListNode.getHead(StringUtil.nextLineFilter(sc)), sc.nextInt()));
        }
    }
}
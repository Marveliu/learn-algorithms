import java.util.*;

/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/submissions/
 * 
 * 类似：Reverse Nodes in k-Group
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        int len = getLen(head);
        return dfs(head, len, 2);
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
            ListNode.log(s.swapPairs(ListNode.getHead(StringUtil.nextLineFilter(sc))));
        }
    }
}
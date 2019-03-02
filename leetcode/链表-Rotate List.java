import java.util.*;

/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 * 
 * 1->2->3->4->5->NULL, k = 2
 * 4->5->1->2->3->NULL
 * 
 * rotate the list to the right by k places
 * 
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode next = head;
        int len = 0;
        // 长度计算
        while (next != null) {
            next = next.next;
            len++;
        }
        if (len == 0 || k == 0)
            return head;
        k = k % len;
        ListNode prev = head;
        next = head;
        while (k >= 0) {
            if (next == null)
                return head;
            next = next.next;
            k--;
        }
        while (next != null) {
            next = next.next;
            prev = prev.next;
        }
        // 旋转
        next = prev.next;
        prev.next = null;
        ListNode p = next;
        if (p == null)
            return head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int k = sc.nextInt();
            sc.nextLine();
            ListNode head = ListNode.getHead(StringUtil.nextLineFilter(sc));
            ListNode.log(s.rotateRight(head, k));
        }
    }
}


// 2
// 1,2,3,4,5
// 4,5,1,2,3

// 4    
// 0,1,2
// 2,0,1
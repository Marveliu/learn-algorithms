import java.util.*;

/**
 * 86. Partition List
 * 
 * https://leetcode.com/problems/partition-list/
 * 
 * 按照x的值进行区分，
 * 小于x的放前面，大于x放后面，且按照原来的顺序
 * 
 * 思路：
 * 维护两个链表，分别记录两种值，最后合并一下
 * 
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }
            // move ahead in the original list
            head = head.next;
        }
        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;
        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode head = ListNode.getHead(StringUtil.nextLineFilter(sc));
            int x = sc.nextInt();
            ListNode ans = s.partition(head, x);
            ListNode.log(ans);
        }
    }
}

// [1,4,3,2,5,2]
// 3

// 2,1
// 2
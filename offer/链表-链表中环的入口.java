import java.util.*;

/**
 * 链表中环的入口结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
 * 思路：快慢指针
 * 
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?
 */
public class Solution {
    
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        slow = pHead.next;
        fast = pHead.next.next;
        while (slow != fast) {
            if (fast != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode.log(ListNode.getHead(StringUtil.nextLineFilter(sc)));
        }
    }
}
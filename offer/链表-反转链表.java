import java.util.*;

/**
 * 反转链表
 * 思路:遍历+头插法
 * 
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca
 */
public class Solution {

    public ListNode ReverseList(ListNode head) {
        ListNode res = head;
        if (head == null)
            return res;
        ListNode point = head.next;
        res.next = null;
        while (point != null) {
            ListNode tmp = null;
            tmp = point.next;
            point.next = res;
            res = point;
            point = tmp;
        }
        return res;
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
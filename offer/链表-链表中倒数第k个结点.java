import java.util.*;

/**
 * 链表中倒数第k个结点
 * 链表
 * 
 * https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a
 */
public class Solution {

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode tmp = head;
        ListNode res = head;
        while (tmp != null) {
            // 计算k，再遍历
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

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode.log(s.FindKthToTail(ListNode.getHead(StringUtil.nextLineFilter(sc)), sc.nextInt()));
        }
    }
}
import java.util.*;

/**
 * 合并两个排序的链表
 * 
 * 思路:dfs
 * 
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337
 */
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
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode.log(s.Merge(ListNode.getHead(StringUtil.nextLineFilter(sc)),
                    ListNode.getHead(StringUtil.nextLineFilter(sc))));
        }
    }
}
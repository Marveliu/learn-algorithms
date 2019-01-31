import java.util.*;

// 82. Remove Duplicates from Sorted List II
// 思路：map存一下，o(n)
public class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Boolean> map = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            if (map.containsKey(p.val)) {
                map.put(p.val, true);
            } else {
                map.put(p.val, false);
            }
            p = p.next;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode prev = root;
        p = head;
        while (p != null) {
            if (map.get(p.val)) {
                prev.next = p.next;
            } else {
                prev = p;
            }
            p = p.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode head = ListNode.getHead(StringUtil.nextLineFilter(sc));
            ListNode ans = s.deleteDuplicates(head);
            ListNode.log(ans);
        }
    }
}
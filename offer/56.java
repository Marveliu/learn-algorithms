import java.util.*;

// 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 
// 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
public class Solution {

    // HashSet<Integer> map = new HashSet<>();

    // dp备忘录
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode root = new ListNode(0);
        root.next = deleteDuplication(pHead.next);
        if (map.contains((pHead.val))) {
            return root.next;
        }
        ListNode prev = root;
        ListNode next = root.next;
        Boolean flag = true;
        while (next != null) {
            if (next.val == pHead.val) {
                map.add(pHead.val);
                prev.next = next.next;
                flag = false;
            }
            next = next.next;
            prev = prev.next;
        }
        if (flag) {
            pHead.next = root.next;
            root.next = pHead;
        }
        return root.next;
    }

    // public ListNode deleteDuplication(ListNode pHead) {
    // HashMap<Integer, Integer> map = new HashMap<>();
    // ListNode root = new ListNode(0);
    // ListNode p = pHead;
    // ListNode tmp = root;
    // while (p != null) {
    // if (map.containsKey(p.val)) {
    // map.put(p.val, map.get(p.val) + 1);
    // } else {
    // map.put(p.val, 1);
    // }
    // p = p.next;
    // }
    // p = pHead;
    // while (p != null) {
    // if (map.get(p.val) == 1) {
    // tmp.next = p;
    // tmp = tmp.next;
    // }
    // p = p.next;
    // }
    // tmp.next = null;
    // return root.next;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ListNode test = ListNode.getHead(in);
            ListNode ans = s.deleteDuplication(test);
            ListNode.log(ans);
        }
    }
}
import java.util.*;

// 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class Solution {

    // 快指针每次前进两个节点
    // 慢指针每次前进一个节点
    // 此处的长度代表了节点的个数
    // x代表非环部分的长度。
    // c代表环的长度。
    // a代表，快慢指针在环中相遇的节点距离入口的距离。
    // 2(x+m*c+a) = x+n*c+a 此时相遇 x = (n-2m-1)*c+c-a
    // 所以，我们可以让一个指针从起点A开始走，让一个指针从相遇点B开始继续往后走，2个指针速度一样，
    // 那么，当从原点的指针走到环入口点的时候（此时刚好走了x）从相遇点开始走的那个指针也一定刚好到达环入口点。所以2者会相遇，且恰好相遇在环的入口点。
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

    // public ListNode EntryNodeOfLoop(ListNode pHead) {
    // HashSet<ListNode> set = new HashSet<>();
    // ListNode p = pHead;
    // while (p != null) {
    // if (set.contains(p)) {
    // return p;
    // } else {
    // set.add(p);
    // p = p.next;
    // }
    // }
    // return null;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
        }
    }
}
import java.util.*;

public class list {

    // 链表交叉
    public void merge(ListNode h1, ListNode h2) {
        ListNode p1 = h1;
        ListNode p2 = h2;
        ListNode tail = p1;
        while (p1 != null && p2 != null) {
            ListNode tmp1 = p1.next;
            ListNode tmp2 = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            tail = p2;
            p1 = tmp1;
            p2 = tmp2;
        }
        if (p2 != null) {
            tail.next = p2;
        }
    }

    // 链表排序
    public ListNode sortList(ListNode head) {
        return merge(head);

        // quickSort(head, null);
        // return head;
    }

    // 归并排序实现
    public ListNode merge(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }
        ListNode slow = start;
        ListNode quick = start;
        // 快慢指针
        while (quick != null && quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode index = slow.next;
        slow.next = null;
        ListNode h1 = merge(start);
        ListNode h2 = merge(index);
        int cmp = h1.val - h2.val;
        ListNode root = (cmp < 0 ? h1 : h2);
        h1 = (cmp < 0 ? h1.next : h1);
        h2 = (cmp < 0 ? h2 : h2.next);
        ListNode p = root;
        // 链表比较并合并
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        p.next = (h1 == null ? h2 : h1);
        return root;
    }

    // 快排实现
    public void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partition(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    public ListNode partition(ListNode head, ListNode end) {
        
        ListNode p1 = head, p2 = head.next;
        while (p2 != end) {
            if (p2.val < head.val) {
                p1 = p1.next;
                // swap p1 p2
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }

        if (p1 != head) {
            int tmp = p1.val;
            p1.val = head.val;
            head.val = tmp;
        }
        return p1;
    }


}
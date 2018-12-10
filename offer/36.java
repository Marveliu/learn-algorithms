import java.util.*;
// 输入两个链表，找出它们的第一个公共结点。

// 1. 计算出二者的长度差值，得到两个长度一样的链表，再进行遍历比较
public class Solution {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        // 链表长度
        int c = 0;
        // 链表长度
        int c1 = 0;
        int c2 = 0;
        while (p1 != null) {
            p1 = p1.next;
            c1++;
        }
        while (p2 != null) {
            p2 = p2.next;
            c2++;
        }

        // 对齐
        p1 = pHead1;
        p2 = pHead2;
        if (c1 > c2) {
            c = c1 - c2;
            while (c > 0) {
                p1 = p1.next;
                c--;
            }
        } else {
            c = c2 - c1;
            while (c > 0) {
                p2 = p2.next;
                c--;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1 == p2)
                return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode l1 = ListNode.getHead(sc.nextLine());
            ListNode l2 = ListNode.getHead(sc.nextLine());
            ListNode l3 = ListNode.getHead(sc.nextLine());

            ListNode p1 = l1;
            ListNode p2 = l2;
            while (p1.next != null) {
                p1 = p1.next;
            }
            while (p2.next != null) {
                p2 = p2.next;
            }
            p1.next = l3;
            p2.next = l3;
            ListNode res = s.FindFirstCommonNode(l1, l2);
            // ListNode.log(res);
        }
    }
}
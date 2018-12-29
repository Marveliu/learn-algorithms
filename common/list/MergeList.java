import java.util.*;

public class MergetList {

    // 链表交替排序
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

    public static void main(String[] args) {
        MergetList s = new MergetList();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            ListNode h1 = ListNode.getHead(in);
            ListNode h2 = ListNode.getHead(sc.nextLine());
            s.merge(h1, h2);
            ListNode.log(h1);
        }
    }
}
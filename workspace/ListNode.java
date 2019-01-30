import java.util.ArrayList;
import java.util.List;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode getHead(List<Integer> s) {
        if (s.size() == 0)
            return null;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        for (int i = 0; i < s.size(); i++) {
            ListNode l = new ListNode(s.get(i));
            tmp.next = l;
            tmp = tmp.next;
        }
        return head.next;
    }

    public static ListNode getHead(String s) {
        if (s.equals(" "))
            return null;
        String[] ss = s.split(",");
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < ss.length; i++) {
            arr.add(Integer.valueOf(ss[i]));
        }
        return getHead(arr);
    }

    public static void log(ListNode head) {
        if (head == null)
            return;
        while (head.next != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
        System.out.println(head.val);
    }
}
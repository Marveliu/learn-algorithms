import java.util.*;

// 61. Rotate List
// 模拟
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        List<ListNode> arr = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            arr.add(p);
            p = p.next;
        }
        k = k % arr.size();
        if (k == 0)
            return head;
        p = arr.get(arr.size() - k - 1);
        ListNode tail = arr.get(arr.size() - 1);
        ListNode root = arr.get(arr.size() - k);
        tail.next = head;
        p.next = null;
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int k = sc.nextInt();
            sc.nextLine();
            ListNode head = ListNode.getHead(StringUtil.nextLineFilter(sc));
            ListNode.log(s.rotateRight(head, k));
        }
    }
}


// 2
// 1,2,3,4,5
// 4,5,1,2,3

// 4    
// 0,1,2
// 2,0,1
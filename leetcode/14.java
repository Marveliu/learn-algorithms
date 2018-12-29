import java.util.*;
// 138. Copy List with Random Pointer
// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
// Return a deep copy of the list.

// 思路, 现在各个节点直接插入一个新的复制节点，在遍历修改复制节点的random，最后进行链表的拆分
public class Solution {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;
        RandomListNode p = head;
        while (p != null) {
            RandomListNode tmp = new RandomListNode(p.label);
            tmp.next = p.next;
            p.next = tmp;
            p = p.next.next;
        }
        p = head;
        while (p != null) {
            RandomListNode tmp = p.next;
            if (p.random != null) {
                tmp.random = p.random.next;
            }
            p = p.next.next;
        }

        RandomListNode root = head.next;
        RandomListNode p1 = head;
        RandomListNode p2 = head.next;
        while (p1.next != null && p2.next != null) {
            RandomListNode tmp1 = p1.next.next;
            RandomListNode tmp2 = p2.next.next;
            p1.next = tmp1;
            p2.next = tmp2;
            p1 = tmp1;
            p2 = tmp2;
        }
        p1.next = null;
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            RandomListNode test = new RandomListNode(-1);
            RandomListNode ans = s.copyRandomList(test);
            System.out.println(ans.label);
        }
    }
}
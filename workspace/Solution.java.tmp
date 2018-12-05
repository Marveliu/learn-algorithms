import java.util.*;

// 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

// 1. 遍历很简单
// 2，递归自带从后往前

public class Solution {

    // 1. 遍历
    // public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    // int len = getLen(listNode);
    // Integer[] tmp = new Integer[len];
    // for (int i = len - 1; i >= 0; i--) {
    // tmp[i] = listNode.val;
    // // arr.add(i, listNode.val);
    // listNode = listNode.next;
    // }
    // return new ArrayList<Integer>(Arrays.asList(tmp));
    // }

    // 2. 递归
    ArrayList<Integer> arr = new ArrayList<Integer>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arr.add(listNode.val);
        }
        return arr;
    }

    public static int getLen(ListNode head) {
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = ListNode.getHead("67,0,24,58");
        s.printListFromTailToHead(head);
        ListNode.log(head);
        // test...
    }
}
/**
 * 234. Palindrome Linked List
 * 
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * 快慢指针，链表反转，比较一下
 * 
 * o(n)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode q = head;
        ListNode s = head;
        while(q != null && q.next != null && q.next.next != null){
            s = s.next;
            q = q.next.next;
        }
        if(head == null || s.next == null){
            return true;
        }
        ListNode node = s.next;
        s.next = null;
        s = node;
        node = s.next;
        s.next = null;
        while(node != null){
            ListNode tmp = node.next;
            node.next = s;
            s = node;
            node = tmp;
        }
        q = head;
        while(s != null && q != null){
            if(s.val != q.val){
                return false;
            }
            s = s.next;
            q = q.next;
        }
        return true;
    }
}
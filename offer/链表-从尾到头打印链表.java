import java.util.*;

/**
 * 从尾到头打印链表
 * 字符串
 * 
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13
 */
public class Solution {

    // 1. 遍历
    // public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    //     int len = getLen(listNode);
    //     Integer[] tmp = new Integer[len];
    //     for (int i = len - 1; i >= 0; i--) {
    //         tmp[i] = listNode.val;
    //         listNode = listNode.next;
    //     }
    //     return new ArrayList<Integer>(Arrays.asList(tmp));
    // }

    // public static int getLen(ListNode head) {
    //     int i = 0;
    //     while (head != null) {
    //         head = head.next;
    //         i++;
    //     }
    //     return i;
    // }

    // 2. dfs
    ArrayList<Integer> ans = null;

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ans = new ArrayList<Integer>();
        dfs(listNode);
        return ans;
    }

    public void dfs(ListNode node) {
        if (node != null) {
            dfs(node.next);
            ans.add(node.val);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            ListNode listNode = ListNode.getHead(sc.nextLine());
            System.out.println(Arrays.toString(s.printListFromTailToHead(listNode).toArray()));
        }
    }
}
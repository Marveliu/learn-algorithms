import java.util.*;
// 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

// 一个指向下一个节点, 不考虑指向自己

// 1. 复制当前节点A为A1,插入A1和A1.next之间
// 2. 遍历A.next， 将A1.random = A.random
// 3. next遍历 拆分成两个链表
public class Solution {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode p = pHead;
        while (p != null) {
            RandomListNode tmp = new RandomListNode(p.label);
            tmp.next = p.next;
            p.next = tmp;
            p = p.next.next;
        }
        p = pHead;
        while (p != null) {
            RandomListNode node = p.next;
            if (p.random != null) {
                node.random = p.random.next;
            }
            p = node.next;
        }
        RandomListNode root = pHead.next;
        RandomListNode tmp;
        p = pHead;
        while (p.next != null) {
            tmp = p.next;
            p.next = tmp.next;
            p = tmp;
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input>>>");

        ArrayList<RandomListNode> arr = new ArrayList<RandomListNode>();

        String[] node = sc.nextLine().split(",");
        for (String n : node) {
            RandomListNode tmp = new RandomListNode(Integer.valueOf(n));
            arr.add(tmp);
        }

        String[] nexts = sc.nextLine().split(",");
        for (int i = 0; i < nexts.length; i++) {
            arr.get(i).next = arr.get(Integer.valueOf(nexts[i]) - 1);
        }

        String[] rans = sc.nextLine().split(",");
        for (int i = 0; i < nexts.length; i++) {
            arr.get(i).random = arr.get(Integer.valueOf(rans[i]) - 1);
        }
        RandomListNode root = arr.get(0);
        RandomListNode res = s.Clone(root);
        for (int i = 0; i < arr.size(); i++) {
            RandomListNode tmp = arr.get(i);
            tmp = null;
        }
        LogUtil.log(res.label);

    }
}

// 1,2,3
// 2,3,1
// 3,2,1
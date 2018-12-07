import java.util.*;
import java.util.stream.Collectors;
// 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

public class Solution {

    // 1. 利用栈的特点: 想像一个区间（以及出栈元素在入栈顺序表的范围），遍历出栈的顺序表，元素不能小于区间下界-1的位置，
    // public boolean IsPopOrder(int[] pushA, int[] popA) {
    // List<Integer> ps = Arrays.stream(pushA).boxed().collect(Collectors.toList());
    // int start = -1;
    // for (int index = 0; index < popA.length; index++) {
    // int tmp = ps.indexOf(popA[index]);
    // if (tmp == -1)
    // return false;
    // if (start == -1) {
    // start = tmp;
    // } else {
    // if (tmp < start) {
    // if (tmp != start - 1) {
    // return false;
    // } else {
    // start = tmp;
    // }
    // }
    // }
    // }
    // return true;
    // }

    // 2. 辅助栈进行消费
    Stack<Integer> s = new Stack<>();

    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int ps = pushA.length - 1;
        int pp = 0;
        while (pp < popA.length && ps >= 0) {
            if (!s.isEmpty() && pushA[ps] == s.peek()) {
                s.pop();
                ps--;
                continue;
            }
            if (popA[pp] != pushA[ps]) {
                s.push(popA[pp]);
                pp++;
            } else {
                pp++;
                ps--;
            }
        }
        return s.isEmpty() && pp == popA.length && ps == -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] t1 = { 1, 2, 3, 4, 5 };
        int[] t2 = { 4, 5, 3, 1, 2 };
        LogUtil.log(s.IsPopOrder(t1, t2));
        // test...
    }
}
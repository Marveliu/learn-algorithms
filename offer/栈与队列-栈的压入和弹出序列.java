import java.util.*;
import java.util.stream.Collectors;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如:
 * 1,2,3,4,5是某栈的压入顺序，
 * 4,5,3,2,1是该压栈序列对应的一个弹出序列
 * 4,3,5,1,2就不可能是该压栈序列的弹出序列
 * 
 * https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106
 */
public class Solution {

    // 1. 利用栈的特点
    // public boolean IsPopOrder(int[] pushA, int[] popA) {
    //     List<Integer> ps = Arrays.stream(pushA).boxed().collect(Collectors.toList());
    //     int start = -1;
    //     // 遍历pop
    //     for (int index = 0; index < popA.length; index++) {
    //         // 获取pop元素对应的push位置
    //         int tmp = ps.indexOf(popA[index]);
    //         if (tmp == -1)
    //             return false;
    //         if (start == -1) {
    //             start = tmp;
    //         } else {
    //             // 在入栈的中间出栈的情况
    //             if (tmp < start) {
    //                 if (tmp != start - 1) {
    //                     return false;
    //                 } else {
    //                     start = tmp;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
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
    }
}
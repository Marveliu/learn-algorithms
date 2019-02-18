import java.util.*;

/**
 * 和为S的连续正数序列
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 
 * 思路:标准解法滑动窗口，通过数学公式可以简化
 * 
 * https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe
 */
public class Solution {

    // 1.窗口滑动:在给定大小和中间位置的模拟窗口进行滑动
    // public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    //     // 存放结果
    //     ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    //     // 两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
    //     int plow = 1, phigh = 2;
    //     while (phigh > plow) {
    //         // 由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
    //         int cur = (phigh + plow) * (phigh - plow + 1) / 2;
    //         // 相等，那么就将窗口范围的所有数添加进结果集
    //         if (cur == sum) {
    //             ArrayList<Integer> list = new ArrayList<>();
    //             for (int i = plow; i <= phigh; i++) {
    //                 list.add(i);
    //             }
    //             result.add(list);
    //             plow++;
    //             // 如果当前窗口内的值之和小于sum，那么右边窗口右移一下
    //         } else if (cur < sum) {
    //             phigh++;
    //         } else {
    //             // 如果当前窗口内的值之和大于sum，那么左边窗口右移一下
    //             plow++;
    //         }
    //     }
    //     return result;
    // }

    
    // 链接：https://www.nowcoder.com/questionTerminal/c451a3fd84b64cb19485dad758a55ebe
    // 知道序列的中间值和长度，也就不难求出这段序列了 (1+n)*n/2 = sum max(n) = sqrt(sum*2);
    // 1. n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
    // 2. n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n.
    // 假设输入sum = 100，我们只需遍历n = 13~2的情况（按题意应从大到小遍历），n = 8时，得到序列[9, 10, 11, 12, 13, 14, 15, 16]；n  = 5时，得到序列[18, 19, 20, 21, 22]。
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int n = (int) Math.sqrt(sum * 2);
        for (; n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int test = sc.nextInt();
            ArrayList<ArrayList<Integer>> res = s.FindContinuousSequence(test);
            for (ArrayList<Integer> var : res) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
// 100
// 18 19 20 21 22
// 9 10 11 12 13 14 15 16

// 15
// 1 2 3 4 5
// 4 5 6
// 7 8
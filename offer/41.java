import java.util.*;
// 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
// 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!

// 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
public class Solution {

    // // 1. ...
    // public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
    // ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    // int len = Math.sqrt(sum * 2);
    // while (true) {
    // int n = sum / len;
    // // 无法构成len的序列
    // if ((len + 1) / 2 > n) {
    // break;
    // }
    // ArrayList<Integer> tmp = scale(len, n, sum);
    // if (tmp != null)
    // res.add(tmp);
    // len++;
    // }
    // // reverse 会提高复杂度，尽量避免
    // // Collections.reverse(res);
    // return res;
    // }

    // //
    // 在给定大小和中间位置的模拟窗口进行滑动，简单问题复杂化了，可以直接用数学推
    // public ArrayList<Integer> scale(int len, int n, int s) {
    // int start = n;
    // int end = n;
    // int sum = n;
    // // 得到len长度的序列，此时只能左移或者右移
    // while (end - start + 1 < len) {
    // if (start != 1) {
    // start--;
    // sum = sum + start;
    // } else {
    // end++;
    // sum = sum + end;
    // }
    // }
    // while (sum <= s) {
    // if (sum == s) {
    // // get it
    // ArrayList<Integer> tmp = new ArrayList<>();
    // for (int i = start; i <= end; i++) {
    // tmp.add(i);
    // }
    // return tmp;
    // }
    // sum = sum - start;
    // start++;
    // end++;
    // sum = sum + end;
    // }
    // return null;
    // }

    // 数学推算
    // (1+n)*n/2 = sum max(n) = sqrt(sum*2);
    // 奇数 n&1 == 1, sum%n == 0
    // 偶数 sum 比如4
    // 5,6,7，这4个数的和是22，平均值是5.5（小数部分为0.5，说明余数是除数的一半） (sum % n) *2==n
    // 
    // sum/n是序列的中间值，往前推(n-1)/2就是起始值。
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
                for (Integer i : var) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
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
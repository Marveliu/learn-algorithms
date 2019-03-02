import java.util.*;
import java.util.stream.Collectors;


/**
 * 89. Gray Code
 * https://leetcode.com/problems/gray-code/
 * 
 * 打印出格雷码
 * 
 * 思路：dp
 * ans    value   i     
 * ans[0] 00      1
 * ans[1] 01      1
 * ans[2] 11      2    ans[2] = ans[1]+ (1 << 1)
 * ans[3] 10      2    ans[3] = ans[0] + (1 << 1)
 * ans[k + v] = ans[v - k - 1] + v;   v 表示新加一位增加的组合，v = i<< (i-1), 规律就是
 * 对称+v,对称点是新加位之后的分割点
 * 
 */
public class Solution {

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        } else if (n < 0) {
            return null;
        }
        int[] ans = new int[1 << n];
        ans[0] = 0;
        ans[1] = 1;
        for (int i = 1; i < n; i++) {
            // 新增一位带来的组合
            int v = 1 << i;
            for (int k = 0; k < v; k++) {
                ans[k + v] = ans[v - k - 1] + v;
            }
        }
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            List<Integer> ans = s.grayCode(n);
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}

// 2
// [0, 1, 3, 2]
// 3
// [0, 1, 3, 2, 6, 7]
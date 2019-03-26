import java.util.*;

/**
 * 最长递增子序列
 * 
 * https://www.nowcoder.com/profile/6851726/test/22591667/25104#summary
 */
public class Solution {

    public int findLongest(int[] A, int n) {
        int length = A.length;
        int[] B = new int[length];
        B[0] = A[0];
        int end = 0;
        for (int i = 1; i < length; ++i) {
            if (A[i] >= B[end]) {
                // 如果当前数比B中最后一个数还大，直接添加
                B[++end] = A[i];
            } else {
                // 否则，需要先找到替换位置
                int pos = findInsertPos(B, A[i], 0, end);
                B[pos] = A[i];
            }
        }
        // System.out.println(Arrays.toString(B));
        return end + 1;
    }

    /**
     * 二分查找第一个大于等于n的位置
     */
    private int findInsertPos(int[] B, int n, int start, int end) {
        while (start < end) {
            // 直接使用(high + low) / 2 可能导致溢出
            int mid = start + (end - start) / 2;
            if (B[mid] < n) {
                start = mid + 1;
            } else if (B[mid] > n) {
                end = mid;
            } else {
                return mid;
            }
        }
        return start;
    }

    // o(n^2)
    // public int findLongest(int[] A, int n) {
    //     if (n == 0)
    //         return 0;
    //     int[] dp = new int[n];
    //     int ans = 0;
    //     Arrays.fill(dp, 1);
    //     for (int i = 1; i < n; i++) {
    //         int cur = A[i];
    //         for (int j = 0; j < i; j++) {
    //             if (cur > A[j]) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //         ans = Math.max(dp[i], ans);
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            System.out.println(s.findLongest(StringUtil.getIntArr(sc), sc.nextInt()));
            sc.nextInt();
        }
    }
}
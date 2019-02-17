import java.util.*;

/**
 * 矩形覆盖
 * 动态规划-斐波那契
 * 2*1 横竖两种方式去覆盖 2*n 铺的方式有两种:
 * 1. 2*1 进1阶
 * 2. 2*2 进2阶
 * 
 * https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6
 */
public class Solution {

    // dfs
    // public int RectCover(int target) {
    //     if (target == 0) {
    //         return 0;
    //     }
    //     if (target == 1) {
    //         return 1;
    //     }
    //     if (target == 2) {
    //         return 2;
    //     }
    //     return RectCover(target - 2) + RectCover(target - 1);
    // }

    // dp
    public int RectCover(int target) {
        int[] dp = new int[Math.max(3, target + 1)];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.RectCover(sc.nextInt()));
        }
    }
}
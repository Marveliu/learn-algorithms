import java.util.*;
import java.io.*;

public class Main {
    static Scanner sc = null;

    public static int solve(int m) {
        int[] cs = { 1, 4, 16, 64 };
        int len = cs.length;
        int[] dp = new int[m + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < len; j++) {
                int cur = cs[j];
                if (i - cur == 0) {
                    dp[i] = 1;
                } else if (i - cur > 0) {
                    dp[i] = Math.min(dp[i], dp[i - cur] + 1);
                }
            }
        }
        return dp[m] > m ? 0 : dp[m];
    }

    public static void main(String[] args) {
        while (sc.hasNext()) {
            int ans = solve(1024 - sc.nextInt());
            System.out.println(ans);
        }
    }

    static {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("testCases.txt"));
            sc = new Scanner(in);
        } catch (Exception e) {
            sc = new Scanner(System.in);
        }
    }
}

import java.util.*;

// 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。
// 求解将哪些物品装入背包可使价值总和最大。

// 动态规划
class Knapsack1 {

    class pair {
        int c;
        int w;

        pair(Integer _c, Integer _w) {
            c = _c;
            w = _w;
        }
    }

    int max(pair[] p, int v) {
        // [商品数][背包容量]
        int[][] dp = new int[p.length + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            // 没有物品时候
            dp[0][i] = 0;
        }
        for (int i = 1; i <= p.length; i++) {
            // 没有容量时候
            dp[i][0] = 0;
            for (int j = 0; j <= v; j++) {
                if (p[i - 1].c <= j) {
                    // 放入背包与不放入背包比较
                    dp[i][j] = Math.max(dp[i - 1][j - p[i - 1].c] + p[i - 1].w, dp[i - 1][j]);
                } else {
                    // 直接不放入背包
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[p.length][v];
    }

    public static void main(String[] args) {
        Knapsack1 s = new Knapsack1();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String ss = sc.nextLine();
            // [(1,2),(1,3),(2,5)]
            String[] in = ss.replace("[(", "").replace(")]", "").split("\\),\\(");
            pair[] ps = new pair[in.length];
            for (int i = 0; i < in.length; i++) {
                String[] tmp = in[i].split(",");
                ps[i] = s.new pair(Integer.valueOf(tmp[0]), Integer.valueOf(tmp[1]));
            }
            int v = sc.nextInt();
            int ans = s.max(ps, v);
            System.out.println(ans);
        }
    }
}

// [(1,2),(1,3),(2,5)]
// 2
// 5

// [(1,2),(1,3),(2,5),(1,4)]
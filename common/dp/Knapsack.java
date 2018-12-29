import java.util.*;

// 有N件物品和一个容量为V的背包。第i件物品的费用是c[i]，价值是w[i]。
// 求解将哪些物品装入背包可使价值总和最大。

// 动态规划
class Knapsack {

    class pair {
        int c;
        int w;

        pair(Integer _c, Integer _w) {
            c = _c;
            w = _w;
        }
    }

    int max(pair[] p, int v) {
        if (p == null || v == 0)
            return 0;
        List<pair> ps = Arrays.asList(p);
        return dp(ps, v, 0);
    }

    int dp(List<pair> ps, int v, int w) {
        if (ps.size() <= 0 || v <= 0)
            return w;
        ArrayList<pair> tmp = new ArrayList<>();
        tmp.addAll(ps);
        pair p = ps.get(0);
        int nv = v;
        int nw = w;
        if (p.c <= v) {
            nv = v - p.c;
            nw = w + p.w;
        }
        tmp.remove(0);
        return Math.max(dp(tmp, nv, nw), dp(tmp, v, w));
    }

    public static void main(String[] args) {
        Knapsack s = new Knapsack();
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
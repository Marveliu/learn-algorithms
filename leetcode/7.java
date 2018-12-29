import java.util.*;
// Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        HashMap<String, Integer> slopes = new HashMap<>();
        for (Point base : points) {
            int vertical = 0;
            int horizontal = 0;
            int same = 0;
            for (Point p : points) {
                if (base == p)
                    continue;
                int x = p.x - base.x;
                int y = p.y - base.y;
                if (x == 0 && y == 0) {
                    same++;
                } else if (x == 0 && y != 0) {
                    vertical++;
                } else if (y == 0 && x != 0) {
                    horizontal++;
                } else {
                    int gcd = get_gcd(y, x);
                    if (gcd == 0)
                        gcd = 1;
                    String slope = String.format("%d,%d", y / gcd, x / gcd);
                    int count = slopes.getOrDefault(slope, 0) + 1;
                    slopes.put(slope, count);
                    // 考虑相同的点
                    max = Math.max(max, count + 1 + same);
                }
            }
            System.out
                    .println(String.format("(%d,%d): same %d, v %d, h %d", base.x, base.y, same, vertical, horizontal));
            for (Map.Entry<String, Integer> var : slopes.entrySet()) {
                System.out.print(var.getValue());
                System.out.print(" ");
            }
            System.out.println();
            max = Math.max(max, same + vertical + 1);
            max = Math.max(max, same + horizontal + 1);
            slopes.clear();
        }
        return max;
    }

    // 最大公约数,辗转相除法
    public static int get_gcd(int a, int b) {
        a = (a >> 31) == 0 ? a : ~a + 1;
        b = (b >> 31) == 0 ? b : ~b + 1;
        int max, min;
        max = (a > b) ? a : b;
        min = (a < b) ? a : b;
        if (max % min != 0) {
            return get_gcd(min, max % min);
        } else
            return min;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String ss = sc.nextLine();
            String[] in = ss.replace("[[", "").replace("]]", "").split("\\],\\[");
            Point[] p = new Point[in.length];
            for (int i = 0; i < p.length; i++) {
                String[] tmp = in[i].split(",");
                p[i] = new Point(Integer.valueOf(tmp[0]), Integer.valueOf(tmp[1]));
            }
            System.out.println();
            int ans = s.maxPoints(p);
            System.out.println(ans);
        }
    }
}

// [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
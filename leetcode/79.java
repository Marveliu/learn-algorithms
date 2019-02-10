import java.util.*;

// 69. Sqrt(x)
// 思路：binary search
public class Solution {

    // Look for the critical point: i * i <= x && (i+1)(i+1) > x
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int i = 1, j = x;
        while (i < j) {
            long mid = i + (j - i) / 2;
            if (mid * mid < x)
                i = (int) mid + 1;
            else
                j = (int) mid;
        }
        return i * i == x ? i : i - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.mySqrt(sc.nextInt()));
        }
    }
}
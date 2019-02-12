import java.util.*;

// 50. Pow(x, n)
public class Solution {

    // 二分
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        // 越界情况
        if (n == Integer.MIN_VALUE) {
            return myPow(x * x, n / 2);
        }
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if (n % 2 == 1)
            return myPow(x * x, n / 2) * x;
        else
            return myPow(x * x, n / 2);
    }

    // 超时 o(n)
    // public double pow(double x, int n) {
    // if (x == 0)
    // return 0;
    // if (n == 0)
    // return 1;
    // if (n < 0) {
    // x = 1 / x;
    // n = Math.abs(n);
    // }
    // double ans = x;
    // for (int i = 2; i <= n; i++) {
    // ans *= x;
    // }
    // return ans;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            double x = sc.nextDouble();
            int n = sc.nextInt();
            System.out.println(s.myPow(x, n));
        }
    }
}
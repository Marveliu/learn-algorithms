import java.util.*;

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 * 
 * 
 * 2.00000, 10
 * 1024.00000
 * 
 * 二分
 */
public class Solution {

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
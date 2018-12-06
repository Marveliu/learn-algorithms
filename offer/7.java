import java.util.*;

// 斐波那契数列
public class Solution {

    // impl...
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        LogUtil.log(s.Fibonacci(6));
        // test...
    }
}
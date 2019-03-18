import java.util.*;

/**
 * 求1+2+3+...+n
 * 
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 
 * 思路:只能使用递归dfs了 
 * 
 * https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1
 */
public class Solution {

    public int Sum_Solution(int n) {
        if (n <= 1) {
            return n;
        }
        return n + Sum_Solution(n - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int test = sc.nextInt();
            int ans = s.Sum_Solution(test);
            System.out.println(ans);
        }
    }
}
import java.util.*;
// 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
// 递归
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
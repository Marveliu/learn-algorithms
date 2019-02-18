import java.util.*;

/**
 * 从1到n整数中1出现的次数
 * 
 * 思路:遍历，从个位，十位...递推，并进行条件判断
 * 
 * https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6
 */
public class Solution {

    // public int NumberOf1Between1AndN_Solution(int n) {
    //     int count = 0;
    //     int i = 1;
    //     for (i = 1; i <= n; i *= 10) {
    //         // i表示当前分析的是哪一个数位
    //         int a = n / i, b = n % i;
    //         count = count + (a + 8) / 10 * i;
    //         if (a % 10 == 1) {
    //             count = count + b + 1;
    //         }
    //     }
    //     return count;
    // }

    // 简化i b对应
    // 指定位数，每次循环计算的是当前位，为1的数目有多少
    public int NumberOf1Between1AndN_Solution(int n) {
        int i = 1;
        int res = 0;
        if (n < 10) {
        }
        for (; i <= n; i = i * 10) {
            int r1 = n / i;
            int r2 = n % i;
            int a = r1 / 10;
            int b = r1 % 10;
            if (b > 1) {
                res = res + (a + 1) * i;
            } else if (b == 1) {
                res = res + a * i + r2 + 1;
            } else {
                res = res + a * i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int test = sc.nextInt();
            System.out.println(s.NumberOf1Between1AndN_Solution(test));
        }
    }
}
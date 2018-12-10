import java.util.*;
// 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
// 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。

// 数学归纳法，找出其中的规律，进行简化，如果实在是锈住了，可以把情况分解一下，肯定是可以做出来的
public class Solution {

    // public int NumberOf1Between1AndN_Solution(int n) {

    // int count = 0;
    // int i = 1;
    // for (i = 1; i <= n; i *= 10) {
    // // i表示当前分析的是哪一个数位
    // int a = n / i, b = n % i;
    // count = count + (a + 8) / 10 * i;
    // if (a % 10 == 1) {
    // count = count + b + 1;
    // }
    // }
    // return count;
    // }

    // 超级复杂的条件判断...
    public int NumberOf1Between1AndN_Solution1(int n) {
        int i = 1;
        int res = 0;
        if (n < 10) {
        }
        for (; i <= n; i = i * 10) {
            int r1 = n / i;
            int r2 = n % i;
            int a = r1 / 10;
            int b = r1 % 10;
            if (a > 1) {
                if (b > 1) {
                    res = res + (a + 1) * i;
                } else if (b == 1) {
                    res = res + a * i + r2 + 1;
                } else {
                    res = res + a * i;
                }
            } else if (a == 1) {
                if (b > 1) {
                    res = res + (a + 1) * i;
                } else if (b == 1) {
                    res = res + a * i + r2 + 1;
                } else {
                    res = res + a * i;
                }
            } else {
                if (b > 1) {
                    res = res + i;
                }
                if (b == 1) {
                    res = res + r2 + 1;
                }
            }
        }
        return res;
    }

    // 简化 i b对应
    // 指定位数，每次循环计算的事当前位，为1的数目有多少
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
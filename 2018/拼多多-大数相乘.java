import java.util.*;

/**
 * 拼多多
 * 最大乘积
 * 
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 */
public class Solution {
    // 链接：https://www.nowcoder.com/questionTerminal/5f29c72b1ae14d92b9c3fa03a037ac5f
    // AC的o(n)代码，一定要注意存储的数组类型是long型（之前是int型就没通过）
    // 在遍历数组是需要记录第一，第二，第三大，和最小，次小的数（负负的正）
    // 返回Math.max(max1*max2*max3,max1*min1*min2)
    static void getLargestMul(long[] num, int len) {
        long max1 = 0, max2 = 0, max3 = 0, min1 = 0, min2 = 0;
        for (int i = 0; i < len; i++) {
            if (num[i] != 0) {
                if (num[i] > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num[i];
                } else if (num[i] > max2) {
                    max3 = max2;
                    max2 = num[i];
                } else if (num[i] > max3) {
                    max3 = num[i];
                } else if (num[i] < min1) {
                    min2 = min1;
                    min1 = num[i];
                } else if (num[i] > min1 && num[i] < min2) {
                    min2 = num[i];
                }
            } else
                continue;

        }
        long max = Math.max(max1 * max2 * max3, max1 * min1 * min2);
        System.out.println(max);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int n = sc.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextLong();
            }
            getLargestMul(array, n);
        }
    }
}
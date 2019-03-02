import java.util.*;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/
 * 
 * 数组表示的数，进行加1的操作
 * 考虑9999 进位并且扩展 10000
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        if (digits == null)
            return null;
        return plusOne(digits, digits.length - 1);
    }

    public int[] plusOne(int[] digits, int index) {
        if (index < 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            int i = 1;
            for (int var : digits) {
                ans[i++] = var;
            }
            return ans;
        }
        int added = ++digits[index];
        if (added == 10) {
            digits[index] = 0;
            return plusOne(digits, index - 1);
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] digits = StringUtil.getIntArr(sc);
            System.out.println(Arrays.toString(s.plusOne(digits)));
        }
    }
}
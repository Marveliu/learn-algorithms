import java.util.*;

/**
 * 
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/
 * 
 * 思路：一个数的逻辑运算，可以看成组成这个数的32位01进行逻辑运算，
 * 1. 一个数的逻辑运算，可以看成组成这个数的32位01进行逻辑运算，
 * 2. 真值表，可以扩展到M-K次 
 * 
 * 参考：https://blog.csdn.net/yutianzuijin/article/details/50597413
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int var : nums) {
            a = (a ^ var) & ~b;
            b = (b ^ var) & ~a;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int[] test = Arrays.asList(in.split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            System.out.println(s.singleNumber(test));
        }
    }
}
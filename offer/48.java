import java.util.*;
// 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
// 考虑从二进制的加法入手，二进制的运算是位运算，&,|,^,>>,<<,>>>

public class Solution {

    // 两个数异或：相当于每一位相加，而不考虑进位；
    // 两个数相与，并左移一位：相当于求得进位；
    // 结果值 = 不考虑进位 + 进位左移，进行迭代，直到进位的
    // 0
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int sum = num1 ^ num2;
            int c = (num1 & num2) << 1;
            num1 = sum;
            num2 = c;
        }
        return num1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int ans = s.Add(num1, num2);
            System.out.println(ans);
        }
    }
}
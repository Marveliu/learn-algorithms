import java.util.*;

// 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
// 取模 n%str.length 提前计算好每一位的位置，也是取模
public class Solution {

    public String LeftRotateString(String str, int n) {
        if (str == null || str.isEmpty())
            return str;
        n = n % str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt((i + n) % (str.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int test = sc.nextInt();
            String ans = s.LeftRotateString(in, test);
            System.out.println(ans);
        }
    }
}
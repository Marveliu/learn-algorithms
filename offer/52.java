import java.util.*;

// 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
public class Solution {

    // 链接：https://www.nowcoder.com/questionTerminal/45327ae22b7b413ea21df13ee7d6429c
    // 当模式中的第二个字符不是“*”时：
    // 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
    // 2、如果 字符串第一
    // 字符和模式中的第一个字符相不匹配，直接返回false。

    // 而当模式中的第二个字符是“*”时：
    // 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
    // 1、模式后移2字符，相当于x*被忽略；
    // 2、字符串后移1字符，模式后移2字符；
    // 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；

    // public boolean match(char[] str, char[] pattern) {
    // if (str == null || pattern == null) {
    // return false;
    // }
    // int strIndex = 0;
    // int patternIndex = 0;
    // return matchCore(str, strIndex, pattern, patternIndex);
    // }

    // public boolean matchCore(char[] str, int strIndex, char[] pattern, int
    // patternIndex) {
    // // 有效性检验：str到尾，pattern到尾，匹配成功
    // if (strIndex == str.length && patternIndex == pattern.length) {
    // return true;
    // }
    // // pattern先到尾，匹配失败
    // if (strIndex != str.length && patternIndex == pattern.length) {
    // return false;
    // }
    // //
    // 模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
    // if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
    // if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
    // || (pattern[patternIndex] == '.' && strIndex != str.length)) {
    // return matchCore(str, strIndex, pattern, patternIndex + 2)//
    // 模式后移2，视为x*匹配0个字符
    // || matchCore(str, strIndex + 1, pattern, patternIndex + 2)//
    // 视为模式匹配1个字符
    // || matchCore(str, strIndex + 1, pattern, patternIndex);//
    // *匹配1个，再匹配str中的下一个
    // } else {
    // return matchCore(str, strIndex, pattern, patternIndex + 2);
    // }
    // }
    // //
    // 模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
    // if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
    // || (pattern[patternIndex] == '.' && strIndex != str.length)) {
    // return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
    // }
    // return false;
    // }

    // dp 备忘录模式
    // 保存每次，DPij str[0:i] pattern[0:j]的比较结果
    public boolean match(char[] str, char[] pattern) {
        boolean[][] dp = new boolean[str.length + 1][pattern.length + 1];
        dp[0][0] = true;
        // "",".*" 初始化场景
        for (int i = 1; i < dp[0].length; i++) {
            if (pattern[i - 1] == '*')
                dp[0][i] = dp[0][i - 2];
        }
        // 遍历str数组
        for (int i = 1; i < dp.length; i++) {
            // 遍历模式数组
            for (int j = 1; j < dp[0].length; j++) {
                if (pattern[j - 1] == '.' || pattern[j - 1] == str[i - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] != str[i - 1] && pattern[j - 2] != '.')
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] == true ? 1 : 0);
                System.out.print(" ");
            }
            System.out.println();
        }
        return dp[str.length][pattern.length];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            String pattern = sc.nextLine();
            Boolean ans = s.match(in.toCharArray(), pattern.toCharArray());
            System.out.println(ans);
        }
    }
}
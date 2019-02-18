import java.util.*;
/**
 * 把字符串转换成整数
 * 
 * https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e
 */
public class Solution {

    public int StrToInt(String str) {
        if (str.length() <= 0)
            return 0;
        int ans = 0;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // + -
            if (c == '+' || c == '-') {
                if (i == 0) {
                    flag = c == '+';
                    continue;
                } else {
                    return 0;
                }
            }
            int tmp = c - '0';
            if (tmp > 9) {
                return 0;
            } else {
                ans = ans + tmp * (int) Math.pow(10, str.length() - i - 1);
            }
        }
        return flag ? ans : 0 - ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int ans = s.StrToInt(in);
            System.out.println(ans);
        }
    }
}

// Input>>>
// -1234
// -1234
// Input>>>
// 1234
// 1234
// Input>>>
// 1234
// 1234
// Input>>>
// !asd
// 0
// Input>>>
// 1223+
// 12225
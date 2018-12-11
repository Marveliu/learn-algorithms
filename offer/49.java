import java.util.*;
// 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
// 多思考一下可能出现的情况
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
import java.util.*;
// 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

public class Solution {

    public boolean isNumeric(char[] str) {
        if (str.length == 0)
            return false;
        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[index] == 'e' || str[index] == 'E')
                break;
            index++;
        }
        if (index != str.length) {
            return isNumL(str, 0, index - 1) && isNumR(str, index + 1, str.length - 1);
        }
        return isNumL(str, 0, index - 1);
    }

    public boolean isNumL(char[] cs, int start, int end) {
        boolean dot = false;
        for (int i = start; i <= end; i++) {
            if (cs[i] - '0' > 9 || cs[i] - '0' < 0) {
                if ((cs[i] == '+' || cs[i] == '-') && i == start) {
                    continue;
                }
                if (cs[i] == '.') {
                    if (dot)
                        return false;
                    dot = true;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public boolean isNumR(char[] cs, int start, int end) {
        if (start > end)
            return false;
        for (int i = start; i <= end; i++) {
            if (cs[i] - '0' > 9 || cs[i] - '0' < 0) {
                if ((cs[i] == '+' || cs[i] == '-') && i == start) {
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            char[] in = sc.nextLine().toCharArray();
            boolean ans = s.isNumeric(in);
            System.out.println(ans);
        }
    }
}

// Input>>>
// 1234
// true
// Input>>>
// 1.2
// true
// Input>>>
// 1.2.3
// false
// Input>>>
// 1Ee
// false
// Input>>>
// 1.1E2
// true
// Input>>>
// -1.1E2.2
// true
// Input>>>
// -1.1.E2.3.2
// false
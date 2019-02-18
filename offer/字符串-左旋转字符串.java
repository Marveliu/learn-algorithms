import java.util.*;
/**
 * 左旋转字符串
 * 思路:取模
 * 输入：abcXYZdef
 * 输出：XYZdefabc
 * 
 * 取模 n%str.length 提前计算好每一位的位置，也是取模。
 * 
 * https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec
 */
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
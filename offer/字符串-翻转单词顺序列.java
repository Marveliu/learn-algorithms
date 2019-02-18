import java.util.*;

/**
 * 翻转单词顺序列
 * 输入：student. a am I
 * 输出：I am a student.
 * 
 * 思路:栈压入字符串，然后弹出
 * 
 * https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3
 */
public class Solution {

    public String ReverseSentence(String str) {
        if (str == null || str.isEmpty() || str.split(" ").length == 0) {
            return str;
        }
        String[] cs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = cs.length - 1; i > 0; i--) {
            sb.append(cs[i]);
            sb.append(" ");
        }
        return sb.append(cs[0]).toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            String ans = s.ReverseSentence(in);
            System.out.println(ans);
        }
    }
}
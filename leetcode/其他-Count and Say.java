import java.util.*;

/**
 * 38. Count and Say
 * misleading description
 * 
 * https://leetcode.com/problems/count-and-say/
 * 
 */
public class Solution {

    // 刚开始一直没懂题的意思，其实就是假设第一个是1，然后每一次前面生成的，n指读多少次。
    // n=1，就是1
    // n=2，就是读两次，结果为11
    // n=3，就是读3次,结果为21
    // n=4,就是读4次，结果为1211，
    // 每一次读都是以前一次为基础
    public String countAndSay(int n) {
        int i = 1;
        String result = "1";
        while (i < n) {
            result = countOnce(result);
            i++;
        }
        return result;
    }

    public String countOnce(String res) {
        char c = res.charAt(0);
        int num = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < res.length(); i++) {
            if (res.charAt(i) == c) {
                num++;
                continue;
            }
            sb.append(String.valueOf(num) + c);
            c = res.charAt(i);
            num = 1;
        }
        sb.append(String.valueOf(num) + c);
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
        }
    }
}
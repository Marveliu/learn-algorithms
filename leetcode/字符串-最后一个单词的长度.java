import java.util.*;

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 */
public class Solution {

    // 字符串从后往前查找，直到‘’
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if (arr.length == 0) {
            return 0;
        }
        return arr[arr.length - 1].length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.lengthOfLastWord(sc.nextLine()));
        }
    }
}
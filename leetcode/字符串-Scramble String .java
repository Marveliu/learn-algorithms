import java.util.*;

/**
 * 87. Scramble String 
 * 
 * https://leetcode.com/problems/scramble-string/
 * 
 * 
 * 思路：可能的情况 
 * 1.两个字符串都只有一个字符时只需比较是否相等
 * 2.字符个数大于一时，先判断长度是否相等，在判断是否由相同的字符组成，若否则直接返回false 
 * 3.分隔字符串，有两种情况，一种是不交换，一种是左右交换
 */
public class Solution {

    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 != len2)
            return false;
        if (len1 == 1)
            return s1.equals(s2);
        // 剪枝:若排序后不不相等则必定不满足条件
        char[] chars1 = new char[len1];
        s1.getChars(0, len1, chars1, 0);
        Arrays.sort(chars1);
        char[] chars2 = new char[len1];
        s2.getChars(0, len2, chars2, 0);
        Arrays.sort(chars2);
        if (!(new String(chars1).equals(new String(chars2))))
            return false;

        for (int i = 1; i < len1; i++) {
            String s1left = s1.substring(0, i);
            String s1right = s1.substring(i, len1);
            String s2left = s2.substring(0, i);
            String s2right = s2.substring(i, len1);
            // 在当前分割处没有交换
            if (isScramble(s1left, s2left) && isScramble(s1right, s2right))
                return true;
            // 当前分割处左右交换
            s2right = s2.substring(len1 - i, len1);
            s2left = s2.substring(0, len1 - i);
            if (isScramble(s1left, s2right) && isScramble(s1right, s2left))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(s.isScramble(s1, s2));
        }
    }
}

// great
// rgeats

// cabcd
// cadcb
import java.util.*;

/**
 * 28. Implement strStr()
 * https://leetcode.com/problems/implement-strstr/submissions/
 * 
 * KMP: 
 * 1. https://blog.csdn.net/v_july_v/article/details/7041827 
 * 2. http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * 
 */
public class Solution {

    public int strStr(String haystack, String needle) {
        // return haystack.indexOf(needle);
        return KMP(haystack, needle);
    }

    public int KMP(String s, String p) {
        int[] next = new int[p.length()];
        // getNext(p, next);
        getNextVal(p, next);
        int i = 0;
        int j = 0;
        int lens = s.length();
        int lenp = p.length();
        while (i < lens && j < lenp) {
            // 当前字符串匹配成功，继续匹配
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                // 字符串匹配失败，next计算当前的前缀
                j = next[j];
            }
        }
        if (j == lenp) {
            return i - j;
        } else {
            return -1;
        }
    }

    public void getNext(String s, int[] next) {
        int len = s.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            // s.charAt(k) 表示前缀，s.charAt(j) 表示后缀
            if (k == -1 || s.charAt(k) == s.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                // k 重置为k的前缀, 继续比较和回溯
                k = next[k];
            }
        }
    }

    /**
     * 优化，针对p[j] != p[k]，无需继续匹配
     * 
     * @param s
     * @param next
     */
    public void getNextVal(String s, int[] next) {
        if(s.isEmpty()) return;
        int len = s.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            // s.charAt(k) 表示前缀，s.charAt(j) 表示后缀
            if (k == -1 || s.charAt(k) == s.charAt(j)) {
                k++;
                j++;
                if (s.charAt(j) != s.charAt(k)) {
                    next[j] = k;
                } else {
                    // 因为不能出现p[j] = p[next[j]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
                }
            } else {
                // k 重置为k的前缀, 继续比较和回溯
                k = next[k];
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.strStr(sc.nextLine(), sc.nextLine()));
        }
    }
}
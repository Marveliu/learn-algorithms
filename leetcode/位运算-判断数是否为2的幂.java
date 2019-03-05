import java.util.*;

/**
 * 231. Power of Two
 * https://leetcode.com/problems/power-of-two/
 * 
 * 位运算：有且仅有一位为1
 * 
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        while( (n & 1) != 1){
            n = n >> 1;
        }
        n = n >> 1;
        if(n != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.isPowerOfTwo(sc.nextInt()));
        }
    }
}
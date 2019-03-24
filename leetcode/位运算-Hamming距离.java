import java.util.*;

/**
 * 461. Hamming Distance
 * 
 * https://leetcode.com/problems/hamming-distance/
 * 
 * 位运算 最后一位进行异或
 */
public class Solution {

    public int hammingDistance(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((x & 1) ^ (y & 1)) > 0) {
                ans++;
            }
            x = x >>> 1;
            y = y >>> 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(1));
        while (true) {
            System.out.println("Input>>>");
            System.out.println(s.hammingDistance(sc.nextInt(), sc.nextInt()));
        }
    }
}
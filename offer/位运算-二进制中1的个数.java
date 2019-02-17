import java.util.*;
/**
 * 二进制中1的个数
 * 思路：无符号游移与1与运算
 * >>> 无符号右移
 * 
 * https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8
 */
public class Solution {

    public int NumberOf1(int n) {
        int count = 0;
        do {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >>> 1;
        } while (n != 0);
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.NumberOf1(sc.nextInt()));
        }
    }
}
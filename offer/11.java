import java.util.*;

// 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
// 无符号右移动，与1进行与运算
public class Solution {

    // impl...
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
        LogUtil.log(s.NumberOf1(2));
        // test...
    }
}
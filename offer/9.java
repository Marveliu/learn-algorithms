import java.util.*;

// 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
// 斐波那契变种
public class Solution {

    // impl...
    public int JumpFloorII(int target) {
        int count = 0;
        if (target <= 1) {
            return 1;
        }
        for (int index = 1; index <= target; index++) {
            count = count + JumpFloorII(target - index);
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        LogUtil.log(s.JumpFloor(5));
        // test...
    }
}
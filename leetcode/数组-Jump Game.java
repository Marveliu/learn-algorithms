import java.util.*;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/
 * 
 * 注意：题目是范围，不是指单一跳跃点
 * [2,3,1,1,4] true
 * [3,2,1,0,4] false
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > reachable)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            System.out.println(s.canJump(nums));
        }
    }
}
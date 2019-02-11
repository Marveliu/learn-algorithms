import java.util.*;

// 55. Jump Game
// 注意：题目是范围，不是指单一跳跃点...有点坑。
public class Solution {

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i=0; i<nums.length; ++i) {
            if (i > reachable) return false;
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
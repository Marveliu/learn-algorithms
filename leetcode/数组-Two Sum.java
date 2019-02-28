import java.util.*;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * 
 * hash表，o(n)
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer j = map.get(target - nums[i]);
            if (j != null && i != j) {
                int[] ans = new int[2];
                ans[0] = (i > j ? j : i);
                ans[1] = (i > j ? i : j);
                return ans;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(Arrays.toString(s.twoSum(StringUtil.getIntArr(sc), sc.nextInt())));
        }
    }
}
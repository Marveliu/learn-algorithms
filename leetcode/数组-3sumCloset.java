import java.util.*;

/**
 * 16. 3Sum Closest
 * 
 * https://leetcode.com/problems/3sum-closest/
 * 
 * 类似3sum
 * o(n*n)
 */
public class Solution {

    // o(n * n)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = target;
        for (int i = 0; i < len; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int val = nums[i] + nums[l] + nums[r];
                // 差值比较
                int ndiff = target - val;
                if (Math.abs(ndiff) < Math.abs(diff)) {
                    diff = ndiff;
                    ans = val;
                }
                if (val > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            int[] n = StringUtil.getIntArr(sc);
            int target = sc.nextInt();
            System.out.println(s.threeSumClosest(n, target));
        }
    }
}

// -1,2,1,-4
// 1
// -3,0,1,2
// 1
// -1,-1,1,3
// -1
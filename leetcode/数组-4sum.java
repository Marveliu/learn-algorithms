import java.util.*;


/**
 * 18. 4Sum
 * 
 * https://leetcode.com/problems/4sum/
 * 
 * o(n^3)
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ans;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1;
                int r = len - 1;
                int sum = nums[i] + nums[j];
                while (l < r) {
                    int val = sum + nums[l] + nums[r];
                    if (val == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        l++;
                        r--;
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (val < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] n = StringUtil.getIntArr(sc);
            for (List<Integer> var : s.fourSum(n, sc.nextInt())) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}

// 1,0,-1,0,-2,2
// 0
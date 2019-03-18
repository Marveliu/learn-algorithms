import java.util.*;

/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 * 
 * n^2 寻找
 * 1. 二分查找
 * 2. 区间比较
 * 
 */
public class Solution {

    // o(n * n)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return ans;
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                int val = nums[i] + nums[l] + nums[r];
                if (val == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
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
                } else if (val > 0) {
                    r--;
                } else {
                    l++;
                }

            }
        }
        return ans;
    }



    // o(n*n*log(n))
    // public List<List<Integer>> threeSum(int[] nums) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     if (nums == null || nums.length < 3)
    //         return ans;
    //     Arrays.sort(nums);
    //     int len = nums.length;
    //     for (int i = 0; i < len; i++) {
    //         if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
    //             continue;
    //         }
    //         for (int j = i + 1; j < len; j++) {
    //             if (j - 1 >= i + 1 && nums[j] == nums[j - 1]) {
    //                 continue;
    //             }
    //             int tmp = 0 - nums[i] - nums[j];
    //             if (binarySearch(nums, j + 1, len - 1, tmp) != -1) {
    //                 List<Integer> list = new ArrayList<>();
    //                 list.add(nums[i]);
    //                 list.add(nums[j]);
    //                 list.add(tmp);
    //                 ans.add(list);
    //             }
    //         }
    //     }
    //     return ans;
    // }

    // public int binarySearch(int[] n, int start, int end, int target) {
    //     int ans = -1;
    //     while (start <= end) {
    //         int mid = (start + end) >> 1;
    //         int cur = n[mid];
    //         if (cur == target) {
    //             ans = mid;
    //             break;
    //         } else if (cur < target && target <= n[end]) {
    //             start = mid + 1;
    //         } else if (cur > target && target >= n[start]) {
    //             end = mid - 1;
    //         } else {
    //             break;
    //         }
    //     }
    //     return ans;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            int[] n = StringUtil.getIntArr(sc);
            for (List<Integer> var : s.threeSum(n)) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}

// -1,0,1,2,-1,-4
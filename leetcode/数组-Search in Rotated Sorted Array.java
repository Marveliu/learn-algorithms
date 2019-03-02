import java.util.*;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * 思路：
 * 一次二分查找，找到分界点
 * 对两边进行二分查找，找到目标值
 * 
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) {
            if (start + 1 == end) {
                mid = start;
                break;
            }
            mid = (start + end) / 2;
            if (nums[start] > nums[mid] && nums[mid] < nums[end]) {
                start = mid;
            } else if (nums[start] < nums[mid] && nums[mid] > nums[end]) {
                end = mid;
            } else {
                mid = start;
                break;
            }
        }
        return Math.max(search(nums, 0, mid - 1, target), search(nums, mid, nums.length - 1, target));
    }

    public int search(int[] nums, int start, int end, int target) {
        if (start < 0 || end < 0)
            return -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            int target = sc.nextInt();
            int ans = s.search(nums, target);
            System.out.println(ans);
        }
    }
}

// [4,5,6,7,0,1,2]
// 0
// 4
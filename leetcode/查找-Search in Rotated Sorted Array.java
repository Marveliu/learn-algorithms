import java.util.*;

/**
 * 33. Search in Rotated Sorted Array
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        int mid = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                mid = i;
            }
        }
        return Math.max(search(nums, 0, mid - 1, target), search(nums, mid, nums.length - 1, target));
    }

    public int search(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return (start < nums.length && nums[start] == target) ? start : -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.search(StringUtil.getIntArr(sc), sc.nextInt()));
        }
    }
}
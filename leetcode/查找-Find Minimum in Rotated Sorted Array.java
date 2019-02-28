import java.util.*;

/**
 * 153. Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * 
 * 查找，找到转折点
 * o(n) 遍历
 * o(logn) 二分，mid必定位于选择数组两部分之一
 * 1. nums[start] < nums[mid] && nums[mid] > nums[end]
 * 2. nums[start] > nums[mid] && nums[end] > nums[mid]
 * 如果不在了，说明出结果，不是start，就是end
 */
public class Solution {

    // public int findMin(int[] nums) {
    // if(nums.length == 1) return nums[0];
    // int i = 1;
    // for(; i < nums.length; i++){
    // if(nums[i-1] > nums[i]){
    // break;
    // }
    // }
    // return Math.min(nums[0],nums[Math.min(i,nums.length-1)]);
    // }

    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[start] < nums[mid] && nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[start] > nums[mid] && nums[end] > nums[mid]) {
                end = mid;
            } else {
                break;
            }
        }
        return Math.min(nums[start],nums[end]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.findMin(StringUtil.getIntArr(sc)));
        }
    }
}
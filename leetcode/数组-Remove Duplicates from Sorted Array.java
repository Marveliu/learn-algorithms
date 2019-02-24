import java.util.*;

/**
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * 数组
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int offset = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                offset++;
            }
            nums[i - offset] = nums[i];
        }
        return nums.length - offset;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            System.out.println(s.removeDuplicates(nums));
            System.out.println(Arrays.toString(nums));
        }
    }
}
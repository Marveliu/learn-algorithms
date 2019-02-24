import java.util.*;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/submissions/
 * 
 * 
 */
public class Solution {

    public int removeElement(int[] nums, int val) {
        int offset = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                offset++;
                continue;
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
            int val = sc.nextInt();
            System.out.println(s.removeElement(nums, val));
            System.out.println(Arrays.toString(nums));
        }
    }
}
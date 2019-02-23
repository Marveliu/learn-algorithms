import java.util.*;

/**
 * 31. Next Permutation https://leetcode.com/problems/next-permutation/
 * 
 * 思路： 1,3,2 从后往前遍历，找到第一个i-1 < i 的情况，说明可以产生更大的值
 * 注意，但是不代表就是i与i-1交换，应为可能存在p>i，并且p对应的值更小。
 * 
 */
// 1,2,3 → 1,3,2
// 3,2,1 → 1,2,3
// 1,1,5 → 1,5,1
public class Solution {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        for (int j = nums.length - 2; j >= 0; j--) {
            if (nums[j] < nums[j + 1]) { // Scan from last to first, to find the break point
                for (int k = nums.length - 1; j < k; k--) {
                    if (nums[j] < nums[k]) { // Scan from last to swap the break point with the least cost
                        int temp = nums[k];
                        nums[k] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                reverseArray(nums, j + 1, nums.length - 1); // swap the descending subarry to ascending order
                return;
            }
        }
        reverseArray(nums, 0, nums.length - 1); // corner case, {3,2,1} -> {1,2,3}
    }

    private void reverseArray(int[] nums, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] num = StringUtil.getIntArr(sc);
            s.nextPermutation(num);
            System.out.println(Arrays.toString(num));
        }
    }
}
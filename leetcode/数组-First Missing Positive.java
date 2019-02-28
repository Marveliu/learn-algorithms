import java.util.*;

/**
 * 41. First Missing Positive
 * https://leetcode.com/problems/first-missing-positive/
 * 
 * input:[3,4,-1,1] 
 * output:2
 * 
 * 思路：变种的计数排序，和自身值对应的下标进行交换
 * 遍历，如果当前索引的值不等于索引值+1，则表示缺失值。
 */
public class Solution {

    // 直接进行交换
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(StringUtil.nextLineFilter(sc).split(",")).stream()
                    .mapToInt(item -> Integer.valueOf(item)).toArray();
            int ans = s.firstMissingPositive(test);
            System.out.println(ans);
        }
    }
}
import java.util.*;


// 41. First Missing Positive
// Given an unsorted integer array, find the smallest missing positive integer.
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

    // 类似于基数排序，但是空间复杂度是o(n)
    // public int firstMissingPositive(int[] nums) {
    // int[] visit = new int[nums.length];
    // for (int var : nums) {
    // if (var <= nums.length && var > 0) {
    // visit[var - 1] = var;
    // }
    // }
    // for (int i = 0; i < nums.length; i++) {
    // if (visit[i] != i + 1) {
    // return i + 1;
    // }
    // }
    // return nums.length + 1;
    // }

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
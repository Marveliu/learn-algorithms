import java.util.*;

// 81. Search in Rotated Sorted Array II
// 二叉搜索
public class Solution {

    // impl...
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int mid = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                mid = i;
            }
        }
        return search(nums, 0, mid - 1, target) || search(nums, mid, nums.length - 1, target);
    }

    public boolean search(int[] nums, int start, int end, int target) {
        if (start < 0 || end < 0)
            return false;
        for (int i = start; i <= end; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            int target = sc.nextInt();
            boolean ans = s.search(nums, target);
            System.out.println(ans);
        }
    }
}
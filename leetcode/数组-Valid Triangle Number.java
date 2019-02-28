import java.util.*;

/**
 * 611. Valid Triangle Number
 * https://leetcode.com/problems/valid-triangle-number/
 * 
 * [2,2,3,4]
 * 3
 * 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * 
 */
public class Solution {

    // binaray Search o(n^2 logn)
    public int triangleNumber(int[] nums) {
        if (nums.length < 3)
            return 0;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            for (int j = i + 1; j < nums.length - 1; j++) {
                // binarySearch 两边之和大于第三边 两边之和为下边界
                int index = binarySearch(j + 1, nums.length - 1, nums[i] + nums[j], nums);
                if (index != -1 && index > j) {
                    ans = ans + index - j;
                }
            }
        }
        return ans;
    }

    public int binarySearch(int start, int end, int value, int[] nums) {
        if (start > end)
            return end;
        int mid = (end - start) / 2 + start;
        if (nums[mid] < value) {
            return binarySearch(mid + 1, end, value, nums);
        } else {
            return binarySearch(start, mid - 1, value, nums);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(StringUtil.nextLineFilter(sc).split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            int ans = s.triangleNumber(test);
            System.out.println(ans);
        }
    }
}
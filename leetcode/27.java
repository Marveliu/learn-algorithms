import java.util.*;

// 611. Valid Triangle Number
// 需要先进行排序一下
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
                // binarySearch
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

    // dp o(n^3)
    // public int triangleNumber(int[] nums) {
    // if (nums.length < 3)
    // return 0;
    // Arrays.sort(nums);
    // System.out.println(Arrays.toString(nums));
    // int[] res = new int[nums.length];
    // for (int i = 2; i < nums.length; i++) {
    // if (nums[i] == 0)
    // continue;
    // for (int j = 0; j + 2 <= i; j++) {
    // for (int k = j + 1; k < i; k++) {
    // int val = nums[j] + nums[k];
    // if (val > nums[i]) {
    // res[i]++;
    // }
    // }
    // }
    // }
    // int ans = 0;
    // for (int var : res) {
    // ans += var;
    // }
    // System.out.println(Arrays.toString(res));
    // return ans;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(StringUtil.nextLineFilter(sc).split(",")).stream()
                    .mapToInt(item -> Integer.valueOf(item)).toArray();
            int ans = s.triangleNumber(test);
            System.out.println(ans);
        }
    }
}
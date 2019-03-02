import java.util.*;

/**
 * 75. Sort Colors
 * https://leetcode.com/problems/sort-colors/
 * 
 * 基数排序或者归并排序
 * 快排很有可能退化
 * 
 */
public class Solution {

    public void sortColors(int[] nums) {
        // countSort(nums);
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int[] tmp = new int[end - start + 1];
        int index = 0;
        int l = start;
        int r = mid + 1;
        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                tmp[index] = nums[l];
                l++;
            } else {
                tmp[index] = nums[r];
                r++;
            }
            index++;
        }
        int e = (l > mid) ? end : mid;
        for (int t = (l > mid) ? r : l; t <= e; t++) {
            tmp[index++] = nums[t];
        }
        index = 0;
        for (int i = start; i <= end; i++) {
            nums[i] = tmp[index++];
        }
    }

    public void countSort(int[] nums) {
        int[] counts = new int[3];
        for (int var : nums) {
            counts[var]++;
        }
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] != 0) {
                nums[index] = i;
                index++;
                counts[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            s.sortColors(nums);
            for (int var : nums) {
                System.out.print(var + " ");
            }
            System.out.println();
        }
    }
}

// 2,0,2,1,1,0
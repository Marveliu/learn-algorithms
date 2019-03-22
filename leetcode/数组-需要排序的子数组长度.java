import java.util.*;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * 
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 * 
 * [2, 6, 4, 8, 10, 9, 15] [6, 4, 8, 10, 9]
 * 
 * 1. sort一下，缩减窗口
 * 2. 单调栈，获得左右两个临界区，https://www.youtube.com/watch?v=8wHH9txAK34
 */
public class Solution {


    // 时间复杂度：o(n)
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int leftBound = len - 1;
        int rightBound = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty() || nums[i] >= nums[stack.peek()]) {
                stack.push(i);
            } else {
                leftBound = Math.min(leftBound, stack.pop());
                i--;
            }
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty() || nums[i] <= nums[stack.peek()]) {
                stack.push(i);
            } else {
                rightBound = Math.max(rightBound, stack.pop());
                i++;
            }
        }
        return rightBound - leftBound > 0 ? rightBound - leftBound : 0;
    }

    // nlog(n)
    // public int findUnsortedSubarray(int[] nums) {
    //     int len = nums.length;
    //     int[] sort = new int[len];
    //     for (int i = 0; i < len; i++) {
    //         sort[i] = nums[i];
    //     }
    //     Arrays.sort(sort);
    //     int l = 0;
    //     int r = len - 1;
    //     while (l <= r && (nums[l] == sort[l] || nums[r] == sort[r])) {
    //         if (nums[l] == sort[l]) {
    //             l++;
    //         }
    //         if (nums[r] == sort[r]) {
    //             r--;
    //         }
    //     }
    //     return (l > r ? 0 : r - l + 1);
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.findUnsortedSubarray(StringUtil.getIntArr(sc)));
        }
    }
}

// 1 2 3 4
// 4 3 2 1
// 1 2 3
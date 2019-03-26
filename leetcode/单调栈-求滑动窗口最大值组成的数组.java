import java.util.*;

/**
 * 239. Sliding Window Maximum
 * 
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * 思路：维护区间内的单调栈
 * 参考：https://www.youtube.com/watch?v=2SXqBsTR6a8
 * 
 * 时间复杂度：o(n)
 * 空间复杂度：o(k)
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < k || k == 0) {
            return new int[0];
        }
        int[] ans = new int[len - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            while (!queue.isEmpty() && cur >= nums[queue.getLast()]) {
                queue.pollLast();
            }
            if (!queue.isEmpty() && i - queue.getFirst() >= k) {
                queue.pollFirst();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[queue.getFirst()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            int k = sc.nextInt();
            sc.nextLine();
            System.out.println(Arrays.toString(s.maxSlidingWindow(nums, k)));
        }
    }
}

// [7,2,4]
// 2
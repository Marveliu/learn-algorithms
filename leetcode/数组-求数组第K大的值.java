import java.util.*;

/**
 * 215. Kth Largest Element in an Array
 * 
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * 思路：快速查找
 * 
 * 时间复杂度：o(nlog(n))
 */
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len < k)
            return -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(len - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int s = stack.pop();
            int e = stack.pop();
            if (s <= e) {
                int i = partition(nums, s, e);
                if (i == k - 1) {
                    return nums[i];
                } else if (i < k - 1) {
                    stack.push(e);
                    stack.push(i + 1);
                } else {
                    stack.push(i - 1);
                    stack.push(s);
                }
            }
        }
        return -1;
    }

    public int partition(int[] nums, int s, int e) {
        int key = nums[e];
        int p = s - 1;
        int i = s;
        for (; i < e; i++) {
            if (nums[i] > nums[e]) {
                p++;
                int tmp = nums[i];
                nums[i] = nums[p];
                nums[p] = tmp;
            }
        }
        p++;
        nums[e] = nums[p];
        nums[p] = key;
        return p;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            int k = sc.nextInt();
            sc.nextLine();
            System.out.println(s.findKthLargest(nums, k));
            System.out.println(Arrays.toString(nums));
        }
    }
}
import java.util.*;

/**
 * 4. Median of Two Sorted Arrays
 * 
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * 1. 对两个有序数组进行二分查找，如果查找第K小的值，那么显然存在与A[0-k] 与 B[0-k] 中
 * 
 * 2. 对此k/2，对于A[mid]与B[mid]进行比较，如果前者较小，说明K值存在于 A[mid - k/2] 与 B[0 - K] 之间的
 * K/2的范围内。
 * 
 * 3. 然后不断进行二分，直到k = 1;
 * 
 * 时间复杂度：o(log n + m )
 */
public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            // 偶数中位数情况
            return (findKth(nums1, 0, nums2, 0, n / 2) + findKth(nums1, 0, nums2, 0, n / 2 + 1)) / 2.0;
        }
        return findKth(nums1, 0, nums2, 0, n / 2 + 1);
    }

    public int findKth(int[] A, int startA, int[] B, int startB, int k) {
        if (startA >= A.length)
            return B[startB + k - 1];
        if (startB >= B.length)
            return A[startA + k - 1];
        if (k == 1) {
            return Math.min(A[startA], B[startB]);
        }
        int halfKthA = startA + k / 2 - 1 < A.length ? A[startA + k / 2 - 1] : Integer.MAX_VALUE;
        int halfKthB = startB + k / 2 - 1 < B.length ? B[startB + k / 2 - 1] : Integer.MAX_VALUE;

        if (halfKthA < halfKthB) {
            return findKth(A, startA + k / 2, B, startB, k - k / 2);
        } else {
            return findKth(A, startA, B, startB + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums1 = StringUtil.getIntArr(sc);
            int[] nums2 = StringUtil.getIntArr(sc);
            System.out.println(s.findMedianSortedArrays(nums1, nums2));
        }
    }
}
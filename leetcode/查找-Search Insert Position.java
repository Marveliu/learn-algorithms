import java.util.*;

/**
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 * 
 * 二分查找
 * 
 */
public class Solution {

    public int searchInsert(int[] A, int target) {
        return binarySearch(A, 0, A.length - 1, target);
    }

    public int binarySearch(int[] A, int start, int end, int target) {
        if(start >= end){
            return A[start] >= target ? start : start + 1;
        }
        int mid = (start + end) / 2;
        if(A[mid] == target) return mid;
        if (A[mid] < target) {
            return binarySearch(A, mid + 1, end, target);
        } else {
            return binarySearch(A, 0, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] A = StringUtil.getIntArr(sc);
            int target = sc.nextInt();
            System.out.println(s.searchInsert(A, target));
        }
    }
}
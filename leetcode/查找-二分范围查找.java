import java.util.*;

/**
 * search-for-a-range
 * https://www.nowcoder.com/practice/e302d06bcdac4171b9768fd354922880
 * 
 * 思路:二分查找边界
 */
public class Solution {

    public int[] searchRange(int[] A, int target) {
        int[] range = new int[2];
        range[0] = searchleft(A, target);
        range[1] = searchright(A, target);
        return range;
    }

    public int searchleft(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target == A[mid]) {
                if (mid == 0 || A[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            } else if (target < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int searchright(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (target == A[mid]) {
                if (mid == A.length - 1 || A[mid + 1] > target) {
                    return mid;
                }
                low = mid + 1;
            } else if (target < A[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] A = StringUtil.getIntArr(sc);
            int target = sc.nextInt();
            System.out.println(Arrays.toString(s.searchRange(A, target)));
        }
    }
}
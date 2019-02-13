import java.util.*;

// 42. Trapping Rain Water
// 数组内计算区间，是two point的问题，有可能涉及峰和坡度
// 因此可以进行拆分，两封之间存在下坡和上坡，可以考虑从两边往中间进行计算
public class Solution {

    public int trap(int[] A) {
        if (A.length < 3)
            return 0;

        int ans = 0;
        int l = 0, r = A.length - 1;

        // find the left and right edge which can hold water
        while (l < r && A[l] <= A[l + 1])
            l++;
        while (l < r && A[r] <= A[r - 1])
            r--;

        while (l < r) {
            int left = A[l];
            int right = A[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= A[++l]) {
                    ans += left - A[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && A[--r] <= right) {
                    ans += right - A[r];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] A = StringUtil.getIntArr(sc);
            System.out.println(s.trap(A));
        }
    }
}
// 312
import java.util.*;


/**
 * 11. Container With Most Water
 * 
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * 蓄水池问题，o(n)
 * 双端指针，移动规则是：小的那一边进行收缩
 */
public class Solution {

    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(area, max);
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.maxArea(StringUtil.getIntArr(sc)));
        }
    }
}
// 1,2,3
// 1,2,3,2
// 1,8,6,2,5,4,8,3,7
// 1,3,2,5,25,24,5
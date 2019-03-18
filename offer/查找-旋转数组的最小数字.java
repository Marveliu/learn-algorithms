import java.util.*;

/**
 * 旋转数组的最小数字 查找
 * 
 * case: 
 * input: 3,4,5,1,2 
 * output: 1,2,3,4,5
 * 
 * 二分查找
 * 
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
 */
public class Solution {

    public int minNumberInRotateArray(int[] array) {
        return find(array);
    }

    public int find(int[] array) {
        int s = 0;
        int e = array.length - 1;
        int ans = 0;
        while (s < e) {
            int mid = (s + e) >> 1;
            int left = array[s];
            int right = array[e];
            int now = array[mid];
            if (now > left && now > right) {
                s = mid;
            } else if (now < left && now < right) {
                e = mid;
            } else {
                // 相等的情况
                ans = Math.min(left, right);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.minNumberInRotateArray(StringUtil.getIntArr(sc)));
        }
    }
}
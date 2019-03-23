import java.util.*;

/**
 * 560. Subarray Sum Equals K
 * 
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 
 * 1. 统计：prefix[i] 表示数组中[0,i]的和
 * 2. 计算：prefix[i] - prefix[j] = k, 即查找，prefix[j] == prefix[i] - k出现的个数，用map存一下
 * 
 * 时间复杂度：o(n)
 * 空间复杂度：o(n)
 */
public class Solution {


    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[] prefix = new int[len];
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (prefix[i] == k)
                ans++;
            ans += map.getOrDefault(prefix[i] - k, 0);
            map.putIfAbsent(prefix[i], 0);
            map.put(prefix[i], map.get(prefix[i]) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.subarraySum(StringUtil.getIntArr(sc), sc.nextInt()));
        }
    }
}

// 1,1,1
// 2

// -1,4,-1,3,0
// 3
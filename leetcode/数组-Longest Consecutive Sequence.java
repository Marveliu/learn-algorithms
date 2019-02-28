import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * 参考：https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
 * 在连续串的收尾两端维护当前串的长度信息，并进行更新，遍历保存最大串的长度。
 * 例如 
 * -  4 5 6 1 2 3
 * 1. 1 0 0 0 0 0 
 * 2. 2 2 0 0 0 0
 * 3. 3 2 3 0 0 0
 * 4. 3 2 3 1 0 0
 * 5. 3 2 3 2 2 0
 * 6. 3 2 6 6 2 6
 * 
 * 即永远在串的首尾维护长度信息
 */
public class Solution {

    public int longestConsecutive(int[] num) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int var : num) {
            if (!map.containsKey(var)) {
                int left = map.containsKey(var - 1) ? map.get(var - 1) : 0;
                int right = map.containsKey(var + 1) ? map.get(var + 1) : 0;
                int sum = left + right + 1;
                if (sum >= ans)
                    ans = sum;
                map.put(var, sum);
                map.put(var - left, sum);
                map.put(var + right, sum);
            } else {
                continue;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int[] test = Arrays.asList(in.split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            System.out.println(s.longestConsecutive(test));
        }
    }
}
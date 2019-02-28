import java.util.*;

/**
 * 134. Gas Station
 * 
 * 思路：贪心算法
 * 
 * 1. 计算每个站点的剩余油量
 * 2. 由于有唯一的解，那么必然是逆方向（从右往左）连续剩余油量最大的节点
 * 
 */
public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0)
            return -1;
        int[] res = new int[gas.length];
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            res[i] = gas[i] - cost[i];
            sum += res[i];
        }

        if (sum < 0)
            return -1;

        int p = gas.length - 1;
        int ans = p;
        int max = Integer.MIN_VALUE;
        sum = 0;
        // 由于必然有唯一解，起始点必定是从左往右，连续资源剩余量最大的那个节点
        for (; p >= 0; p--) {
            sum = sum + res[p];
            if (sum >= max) {
                max = sum;
                ans = p;
            }
        }
        if (res[ans] < 0)
            return -1;
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] gas = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            int[] cost = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            System.out.println(s.canCompleteCircuit(gas, cost));
        }
    }
}
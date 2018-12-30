import java.util.*;
// 134. Gas Station
// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
// Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.


// 思路:贪心算法
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
        // 由于必然有唯一解，起始点必定是，连续资源剩余量最大的那个节点
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
            int[] gas = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            int[] cost = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            System.out.println(s.canCompleteCircuit(gas, cost));
        }
    }
}
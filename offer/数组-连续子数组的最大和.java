import java.util.*;

/**
 * 连续子数组的最大和
 * 
 * 思路:
 * 遍历的同时维护最大和max,和sum值不断的去更新sum值
 * 如果sum+current < current 重新计算
 * 
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484
 */
public class Solution {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;
        if (array.length == 1)
            return array[0];
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            sum = sum + current;
            if (sum <= current) {
                sum = current;
            }
            if (sum >= max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int[] test = Arrays.asList(in.split(",")).stream().mapToInt(i -> Integer.valueOf(i)).toArray();
            int max = s.FindGreatestSumOfSubArray(test);
            System.out.println(max);
        }
    }
}

// Input>>>
// -2,-8,-1,-5,-9
// -1
// Input>>>
// 1,-2,3,10,-4,7,2,-5
// 18
// Input>>>
// 3,-1,2
// 4
// Input>>>
// 1
// 1
// Input>>>
// 2
// 2
// Input>>>
// -1
// -1
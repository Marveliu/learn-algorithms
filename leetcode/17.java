import java.util.*;
// 135. Candy
// There are N children standing in a line. Each child is assigned a rating value.
// You are giving candies to these children subjected to the following requirements:
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.

public class Solution {

    // o(n)
    // 思路：分左右两次比较，计算增值
    // 合并
    public int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;
        int[] lc = new int[ratings.length];
        int[] rc = new int[ratings.length];
        int[] ans = new int[ratings.length];

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                lc[i] = lc[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rc[i] = rc[i + 1] + 1;
            }
        }
        for (int i = 0; i < ratings.length; i++) {
            ans[i] = 1 + (rc[i] > lc[i] ? rc[i] : lc[i]);
        }

        int sum = 0;
        for (int var : ans) {
            sum += var;
        }
        System.out.println(Arrays.toString(ans));
        return sum;
    }

    // o(n^2)
    // public int candy(int[] ratings) {
    // if (ratings.length == 0)
    // return 0;
    // int[] ans = new int[ratings.length];
    // ans[0] = 1;
    // for (int i = 1; i < ratings.length; i++) {
    // int o = ratings[i] - ratings[i - 1];
    // if (o > 0) {
    // ans[i] = ans[i - 1] + 1;
    // } else {
    // ans[i] = 1;
    // for (int j = i - 1; j >= 0; j--) {
    // if (ratings[j] > ratings[j + 1] && ans[j] <= ans[j + 1]) {
    // ans[j] = ans[j + 1] + 1;
    // } else {
    // break;
    // }
    // }
    // }
    // }
    // int sum = 0;
    // for (int var : ans) {
    // sum += var;
    // }
    // System.out.println(Arrays.toString(ans));
    // return sum;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int[] test = Arrays.asList(in.split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            System.out.println(s.candy(test));
        }
    }
}
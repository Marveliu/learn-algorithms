import java.util.*;

/**
 * 135. Candy
 * https://leetcode.com/problems/candy/
 * 
 * 
 * 思路：
 * 左右两个方向进行遍历，满足得分高的比邻居分的糖果更多
 * 最后计算求和，要保证每个人至少有一个糖果
 * 
 * 时间复杂度： o(n)
 */
public class Solution {

   
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
        return sum;
    }

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
import java.util.*;


/**
 * 877. Stone Game
 * https://leetcode.com/contest/weekly-contest-95/problems/stone-game/
 * 
 * 参考：https://blog.csdn.net/huatian5/article/details/82708855
 * 
 * 先手每次可取第1个或者第8个
 * - 假如取1的话，以后甲可以有一直取奇数位置数的权利
 * - 取第8个，以后甲可以有一直取偶数位置数的权利。
 * 那么就可以直接比较偶数和奇数位置的总和，这样甲可以优先选择和大的，保证了所得总和不小于乙
 * 
 * If sum(piles[even]) > sum(piles[odd]), just picks all evens and wins.
 * If sum(piles[even]) < sum(piles[odd]), just picks all odds and wins.
 * 不存在相等的情况，因为和为奇数
 */
public class Solution {

    public boolean stoneGame(int[] piles) {
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.stoneGame(StringUtil.getIntArr(sc)));
        }
    }
}
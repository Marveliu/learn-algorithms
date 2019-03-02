import java.util.*;

/**
 * 40. Combination Sum II
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * dfs 按照一定的次序进行查找
 * 
 * candidates = [10,1,2,7,6,1,5], target = 8,
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 */
public class Solution {

    List<List<Integer>> ans = null;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), -1);
        return ans;
    }

    public void dfs(int[] candidates, int rem, List<Integer> list, int lastTake) {
        if (rem <= 0) {
            if (rem == 0) {
                ans.add(list);
            }
            return;
        }
        for (int i = lastTake + 1; i < candidates.length; i++) {
            int now = candidates[i];
            if (i - 1 >= 0 && candidates[i - 1] == now && i - 1 != lastTake)
                continue;

            List<Integer> nlist = new ArrayList<>(list);
            nlist.add(now);
            dfs(candidates, rem - now, nlist, i);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] candidates = StringUtil.getIntArr(sc);
            int target = sc.nextInt();
            for (List<Integer> var : s.combinationSum2(candidates, target)) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
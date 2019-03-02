import java.util.*;

/**
 * 39. Combination Sum
 * 
 * https://leetcode.com/problems/combination-sum/
 * 
 * dfs 按照一定的次序进行查找
 * 
 */
public class Solution {

    List<List<Integer>> ans = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    public void dfs(int[] candidates, int rem, List<Integer> list, int lastTake) {
        if (rem <= 0) {
            if (rem == 0) {
                ans.add(list);
            }
            return;
        }
        for (int i = lastTake; i < candidates.length; i++) {
            int now = candidates[i];
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
            for (List<Integer> var : s.combinationSum(candidates, target)) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
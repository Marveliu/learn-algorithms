import java.util.*;


/**
 * 90. Subsets II
 * https://leetcode.com/problems/subsets-ii/
 * 
 * 标准的dfs
 * 
 * [1,2,2]
 * 
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(path);
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            List<Integer> nPath = new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums, i + 1, nPath, result);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            List<List<Integer>> ans = s.subsetsWithDup(nums);
            for (List<Integer> var : ans) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
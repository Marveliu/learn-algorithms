import java.util.*;

/**
 * 78. Subsets
 * https://leetcode.com/problems/subsets/submissions/
 * 
 * 不重复
 * dfs
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, -1, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> result) {
        result.add(path);
        for (int i = index + 1; i < nums.length; i++) {
            List<Integer> nPath = new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums, i , nPath, result);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            List<List<Integer>> ans = s.subsets(nums);
            for (List<Integer> var : ans) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}

// 1,2,3
// []
// [1]
// [2]
// [1, 2]
// [3]
// [1, 3]
// [2, 3]
// [1, 2, 3]
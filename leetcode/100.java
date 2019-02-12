import java.util.*;

// 46. Permutations
// 思路：dfs+回溯
public class Solution {

    List<List<Integer>> ans = null;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        dfs(new ArrayList<>(), nums, new int[nums.length]);
        return ans;
    }

    public void dfs(List<Integer> list, int[] nums, int[] v) {
        if (list.size() >= nums.length) {
            ans.add(list);
        }

        for (int i = 0; i < nums.length; i++) {
            if (v[i] != 1) {
                List<Integer> nlist = new ArrayList<>(list);
                nlist.add(nums[i]);
                v[i] = 1;
                dfs(nlist, nums, v);
                v[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            for (List<Integer> var : s.permute(nums)) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
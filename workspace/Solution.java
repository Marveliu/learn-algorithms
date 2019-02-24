import java.util.*;

public class Solution {

    List<List<Integer>> ans = null;
    Set<String> sets = null;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ans = new ArrayList<>();
        sets = new HashSet<>();
        int[] v = new int[nums.length];
        dfs(nums, v, 0, target, 4, -1);
        return ans;
    }

    public void dfs(int[] nums, int[] v, int sum, int target, int n, int last) {
        if (n < 0)
            return;
        if (target == sum && n == 0) {
            add(v, nums);
            return;
        }
        for (int i = last + 1; i < nums.length; i++) {
            dfs(nums, v, sum, target, n, i);
            v[i] = 1;
            dfs(nums, v, sum + nums[i], target, n - 1, i);
            v[i] = 0;
        }
    }

    public void add(int[] v, int[] nums) {
        List<Integer> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v.length; i++) {
            if (v[i] == 1) {
                res.add(nums[i]);
                sb.append(v[i]);
            }
        }
        String s = sb.toString();
        if (!sets.contains(s)) {
            sets.add(s);
        } else {
            return;
        }
        ans.add(res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            for (List<Integer> var : s.fourSum(StringUtil.getIntArr(sc), sc.nextInt())) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
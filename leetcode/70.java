import java.util.*;

// 78. Subsets
// 思路：动态规划
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // ans.get(i-1) 表示所有以nums[i]结尾的子集集合
        List<List<List<Integer>>> ans = new ArrayList<>();
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l.add(l1);
        ans.add(l);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> list = new ArrayList<>();
            ans.add(list);
            int now = nums[i];
            for (int j = 0; j <= i; j++) {
                List<List<Integer>> tmp = new ArrayList<>();
                for (List<Integer> var : ans.get(j)) {
                    List<Integer> t = new ArrayList<>();
                    t.addAll(var);
                    t.add(now);
                    tmp.add(t);
                }
                list.addAll(tmp);
            }
        }

        // sum
        List<List<Integer>> res = new ArrayList<>();
        for (List<List<Integer>> var : ans) {
            res.addAll(var);
        }
        return res;
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
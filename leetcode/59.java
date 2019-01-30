import java.util.*;

import com.sun.swing.internal.plaf.basic.resources.basic;

// 90. Subsets II
// 思路: dp
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<List<Integer>>> ans = new ArrayList<>();
        Set<String> sets = new HashSet<>();
        List<List<Integer>> empty = new ArrayList<>();
        empty.add(new ArrayList<>());
        ans.add(empty);
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> prev = ans.get(i);
            List<List<Integer>> current = new ArrayList<>();
            current.addAll(prev);
            int now = nums[i];
            List<Integer> nlist = new ArrayList<>();
            nlist.add(now);
            if (!isVisited(sets, nlist)) {
                current.add(nlist);
            }
            // 新的组合
            for (List<Integer> var : prev) {
                List<Integer> tmp = new ArrayList<>(var);
                tmp.add(now);
                if (!isVisited(sets, tmp)) {
                    current.add(tmp);
                }
            }
            ans.add(current);
        }
        return ans.get(nums.length);
    }

    public boolean isVisited(Set<String> sets, List<Integer> list) {
        String s = Arrays.toString(list.toArray());
        if (!sets.contains(s)) {
            sets.add(s);
            return false;
        }
        return true;
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
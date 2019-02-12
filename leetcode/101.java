import java.util.*;

// 46. Permutations
// 思路：dfs+回溯
public class Solution {


    // Arrays.sort();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return res;
        boolean[] used = new boolean[nums.length];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }

    // List<List<Integer>> ans = null;
    // Set<String> sets = null;

    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     ans = new ArrayList<>();
    //     sets = new HashSet<>();
    //     dfs(new ArrayList<>(), nums, new int[nums.length]);
    //     return ans;
    // }

    // public void dfs(List<Integer> list, int[] nums, int[] v) {
    //     if (list.size() >= nums.length) {
    //         String str = Arrays.toString(list.toArray());
    //         if (!sets.contains(str)) {
    //             sets.add(str);
    //             ans.add(list);
    //         }
    //         return;
    //     }
    //     for (int i = 0; i < nums.length; i++) {
    //         if (v[i] != 1) {
    //             List<Integer> nlist = new ArrayList<>(list);
    //             nlist.add(nums[i]);
    //             v[i] = 1;
    //             dfs(nlist, nums, v);
    //             v[i] = 0;
    //         }
    //     }
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            for (List<Integer> var : s.permuteUnique(nums)) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
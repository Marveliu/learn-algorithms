import java.util.*;

/**
 * 118. Pascal's Triangle
 * https://leetcode.com/problems/pascals-triangle/
 * 
 * 生成杨辉三角
 * 时间复杂度：o(n^2)
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0)
            return ans;

        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        ans.add(arr);
        for (int i = 1; i < numRows; i++) {
            int len = i + 1;
            List<Integer> prev = ans.get(i - 1);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < len; j++) {
                if (j == 0) {
                    tmp.add(prev.get(j));
                } else if (j == len - 1) {
                    tmp.add(prev.get(j - 1));
                } else {
                    tmp.add(prev.get(j) + prev.get(j - 1));
                }
            }
            ans.add(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int num = sc.nextInt();
            List<List<Integer>> ans = s.generate(num);
            for (List<Integer> var : ans) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}
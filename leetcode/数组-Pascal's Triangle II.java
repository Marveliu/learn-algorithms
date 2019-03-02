import java.util.*;


/**
 * 119. Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * 杨辉三角形，生成第k行，use only O(k) extra space
 * 思路：计算i行的时候直接在i-1的结果数组上进行修改，注意保存原始值。
 * 
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return null;
        Integer[] ans = new Integer[rowIndex + 1];
        int l = 0;
        ans[0] = 1;
        while (l != rowIndex) {
            l++;
            int len = l + 1;
            int prev = ans[0];
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    ans[i] = ans[i];
                } else if (i == len - 1) {
                    ans[i] = prev;
                } else {
                    int tmp = ans[i];
                    ans[i] = ans[i] + prev;
                    prev = tmp;
                }
            }
        }
        return Arrays.asList(ans);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int test = sc.nextInt();
            List<Integer> ans = s.getRow(test);
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}
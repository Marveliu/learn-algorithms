/**
 * 二维数组的查找
 * https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13
 * 
 * 查找
 * 
 * 思路:从左下角往上比较
 */
public class Solution {
    public boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i = rows - 1, j = 0;
        while (i >= 0 && j < cols) {
            if (target < array[i][j])
                i--;
            else if (target > array[i][j])
                j++;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] array = { { 0, 1, 3 }, { 1, 2, 5 } };
        s.Find(1, array);
    }
}


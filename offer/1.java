// 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

// 本质上是一个比较的过程，矩阵给了两个维度增长的趋势，因此可以通过大小比较选择遍历的方向，并且要注意边界检测。

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
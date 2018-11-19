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

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] array = {{0,1,3},{1,2,5}};
        s.Find(1, array);
    }
}
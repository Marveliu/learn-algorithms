import java.util.*;

// 头条，对于排序好的数组进行快速查找
public class Solution {

    public int BinarySearchMax(int[] data, int target) {
        int left = 0;
        int right = data.length - 1;
        while (left < right || data[right] != target) {
            int mid = (left + right) / 2;
            if (data[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        if (data[right] == target)
            return right;
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.BinarySearchMax(StringUtil.getIntArr(sc), sc.nextInt()));
        }
    }
}
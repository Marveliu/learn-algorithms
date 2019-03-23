import java.util.*;

// 冒泡排序
// 稳定
// 时间复杂度：o(n^2)
// 空间复杂度：o(1)
// 改进，判断是否有序
public class Solution {

    public void BubbleSort(int[] n) {
        int len = n.length;
        for (int i = len - 1; i > 0; i--) {
            boolean isSort = true;
            for (int j = 1; j <= i; j++) {
                if (n[j] < n[j - 1]) {
                    int tmp = n[j - 1];
                    n[j - 1] = n[j];
                    n[j] = tmp;
                    isSort = false;
                }
            }
            if (isSort)
                return;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int[] n = StringUtil.getIntArr(sc);
            s.BubbleSort(n);
            System.out.println(Arrays.toString(n));

        }
    }
}
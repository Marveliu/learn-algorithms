import java.util.*;


/**
 * 归并排序
 * 比较排序
 * 时间复杂度:o(logn)
 * 空间复杂度:o(n)
 */
public class mergeSort {

    public int[] sort(int[] n) {
        return sort(n, 0, n.length - 1);
    }

    public int[] sort(int[] n, int start, int end) {
        if (start >= end) {
            return Arrays.copyOfRange(n, start, start + 1);
        }
        int mid = (start + end) / 2;
        int[] left = sort(n, start, mid);
        int[] right = sort(n, mid + 1, end);
        int[] sort = new int[left.length + right.length];
        int lp = 0, rp = 0, i = 0;

        while (lp < left.length && rp < right.length) {
            if (left[lp] <= right[rp]) {
                sort[i++] = left[lp];
                lp++;
            } else {
                sort[i++] = right[rp];
                rp++;
            }
        }
        int[] rem = (lp != left.length ? left : right);
        int ri = (lp != left.length ? lp : rp);
        while (ri < rem.length) {
            sort[i++] = rem[ri++];
        }
        return sort;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] n = StringUtil.getIntArr(sc);
            System.out.println(Arrays.toString(s.mergeSort(n)));
        }
    }
}
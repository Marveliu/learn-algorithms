import java.util.*;
/**
 * 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对
 * 思路：归并排序
 * 
 * https://www.nowcoder.com/practice/96bd6684e04a44eb80e6a68efc0ec6c5
 */
public class Solution {

    // 归并排序
    public int InversePairs(int[] array) {
        int P = mergeSort(array, 0, array.length - 1);
        return P % 1000000007;
    }
    // min->max
    LinkedList<Integer> sort = new LinkedList<>();

    public int mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int lc = mergeSort(array, start, mid) % 1000000007;
        int rc = mergeSort(array, mid + 1, end) % 1000000007;
        int p1 = mid, p2 = end, c = 0;
        while (p1 >= start && p2 >= mid + 1) {
            if (array[p1] > array[p2]) {
                c = c + p2 - mid;
                sort.add(array[p1]);
                p1--;
                if (c >= 1000000007)
                    c = c % 1000000007;
            } else {
                sort.add(array[p2]);
                p2--;
            }
        }
        // add rem
        int rem = (p1 >= start ? p1 : p2);
        int rstart = (p1 >= start ? start : mid + 1);
        while (rem >= rstart) {
            sort.add(array[rem]);
            rem--;
        }
        // write sort to array
        int p = end;
        while (p >= start) {
            array[p] = sort.pollFirst();
            p--;
        }
        return (c + lc + rc) % 1000000007;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            int res = s.InversePairs(test);
            System.out.println(res);
        }
    }
}

// 1,2,3,4,5,6,7,0
// 4,6,3,5,7
import java.util.*;
// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
// 归并排序，注意mod1000000007
public class Solution {

    // 算法复杂度过大
    // public int InversePairs(int[] array) {
    // int count = 0;
    // for (int i = 0; i < array.length; i++) {
    // for (int j = i; j < array.length; j++) {
    // if (array[i] > array[j]) {
    // count++;
    // }
    // }
    // }
    // return count % 1000000007;
    // }

    // 归并排序
    public int InversePairs(int[] array) {
        int P = mergeSort(array, 0, array.length - 1);
        return P % 1000000007;
    }

    // min->max
    LinkedList<Integer> tmp = new LinkedList<>();

    public int mergeSort(int[] array, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int lc = mergeSort(array, start, mid) % 1000000007;
        int rc = mergeSort(array, mid + 1, end) % 1000000007;
        // p1 p2 point max_num
        int p1 = mid;
        int p2 = end;
        // count
        int c = 0;
        // put max
        while (p1 >= start && p2 >= mid + 1) {
            if (array[p1] > array[p2]) {
                c = c + p2 - mid;
                tmp.add(array[p1]);
                p1--;
                if (c >= 1000000007)
                    c = c % 1000000007;
            } else {
                tmp.add(array[p2]);
                p2--;
            }
        }
        // add remained min_nums
        while (p1 >= start) {
            tmp.add(array[p1]);
            p1--;
        }
        while (p2 >= mid + 1) {
            tmp.add(array[p2]);
            p2--;
        }
        // write tmp to array
        int p = end;
        while (p >= start) {
            array[p] = tmp.pollFirst();
            p--;
        }
        return (c + lc + rc) % 1000000007;
    }

    // public void quicksort(int[] array, int start, int end) {
    // int index = partition(array, start, end);
    // if (index != -1) {
    // quicksort(array, start, index - 1);
    // quicksort(array, index + 1, end);
    // }
    // }

    // public int partition(int[] array, int start, int end) {
    // if (start >= end) {
    // return -1;
    // }
    // int key = array[end];
    // int i = start;
    // int j = i - 1;
    // for (; i < end; i++) {
    // if (array[i] < key) {
    // int tmp = array[j + 1];
    // array[j + 1] = array[i];
    // array[i] = tmp;
    // }
    // }
    // // int tmp = array[j + 1];
    // // array[j + 1] = key;
    // // array[end] = tmp;
    // // count
    // count = count + (end - j - 1);
    // return j + 1;
    // }

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
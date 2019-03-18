import java.util.*;
import java.util.stream.Collectors;

/**
 * 调整数组顺序使奇数位于偶数前面
 * 数组
 * 
 * 思路:
 * 1. java的比较器，注意lambda和stream操作
 * 2. 快排的时候比较一下
 * 
 * https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593
 */
public class Solution {

    // 1. Java的比较器
    // public void reOrderArray(int[] array) {
    //     List<Integer> arr = Arrays.stream(array).boxed().collect(Collectors.toList());
    //     Collections.sort(arr, new Comparator<Integer>() {
    //         @Override
    //         public int compare(Integer x1, Integer x2) {
    //             int y1 = x1 % 2;
    //             int y2 = x2 % 2;
    //             if (y1 < y2) {
    //                 return 1;
    //             } else if (y1 > y2) {
    //                 return -1;
    //             } else {
    //                 return x1 - x2;
    //             }
    //         }
    //     });
    //     for (int index = 0; index < arr.size(); index++) {
    //         array[index] = arr.get(index);
    //     }
    //     // 引用，但是实际上修改原来引用的地址，因为对象形参都是复制原有的引用的
    //     array = arr.parallelStream().mapToInt(Integer::valueOf).toArray();
    // }

    // 2. QuickSort + Comparator
    public void reOrderArray(int[] array) {
        QuickSort(array, 0, array.length - 1);
    }

    public void QuickSort(int[] arr, int s, int e) {
        if (s >= e)
            return;
        int p = parition(arr, s, e);
        QuickSort(arr, s, p - 1);
        QuickSort(arr, p + 1, e);
    }

    public int parition(int[] arr, int s, int e) {
        int key = arr[e];
        int j = s;
        int i = j - 1;
        for (; j < e; j++) {
            if (compare(arr[j], key) <= 0) {
                int tmp = arr[i + 1];
                arr[i + 1] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp = arr[i + 1];
        arr[i + 1] = key;
        arr[e] = tmp;
        return i + 1;
    }

    public int compare(int x1, int x2) {
        int y1 = x1 % 2;
        int y2 = x2 % 2;
        if (y1 < y2) {
            return 1;
        } else if (y1 > y2) {
            return -1;
        } else {
            return x1 - x2;
        }
    }

    // test
    public void test(List<Integer> array) {
        array = new ArrayList<>();
        array.add(1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] array = StringUtil.getIntArr(sc);
            s.reOrderArray(array);
            System.out.println(Arrays.toString(array));
        }
    }
}
import java.util.*;
import java.util.stream.Collectors;
// 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

public class Solution {

    // 1. Java的比较器
    // public void reOrderArray(int[] array) {
    // // int[] => List
    // List<Integer> arr =
    // Arrays.stream(array).boxed().collect(Collectors.toList());
    // // Collections.sort 是对List等集合类进行排序，而Arrays.sort是对对象数组进行排序
    // Collections.sort(arr, new Comparator<Integer>() {
    // @Override
    // public int compare(Integer x1, Integer x2) {
    // int y1 = x1 % 2;
    // int y2 = x2 % 2;
    // if (y1 < y2) {
    // return 1;
    // } else if (y1 > y2) {
    // return -1;
    // } else {
    // return x1 - x2;
    // }
    // }
    // });
    // for (int index = 0; index < arr.size(); index++) {
    // array[index] = arr.get(index);
    // }
    // // java 8 stream操作
    // // 修改了int[] array的引用，但是实际上修改原来引用的地址，因为对象形参都是复制原有的引用的
    // // array = arr.parallelStream().mapToInt(Integer::valueOf).toArray();
    // // for (int i = 0; i < array.length; i++) {
    // // System.out.print(array[i] + " ");
    // // }
    // }

    // 2.QuickSort + Comparator
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
        int[] test = { 1, 4, 3, 3, 2, 2, 6, 1, 2, 7 };
        s.reOrderArray(test);
        LogUtil.log(test);
        LogUtil.br();

        // List<Integer> testList =
        // Arrays.stream(test).boxed().collect(Collectors.toList());
        // s.test(testList);
        // LogUtil.log(testList);
    }
}
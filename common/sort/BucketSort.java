import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// 桶排序
// 计数排序也是一种桶排序
// 比较排序
// 时间复杂度:o(n)
// 空间复杂度:o(n)
class BucketSort {

    /**
     * 最大位数
     * 
     * @param s
     * @param len
     */
    public static void sort(int[] s, int len) {
        ArrayList<LinkedList<Integer>> arr = new ArrayList<LinkedList<Integer>>();
        int divisor = (int) (Math.pow(10, len - 1));
        // init
        for (int i = 0; i < s.length; i++) {
            arr.add(new LinkedList<Integer>());
        }

        // insert bucket
        for (int i = 0; i < s.length; i++) {
            int index = (int) (s[i] / divisor);
            add(arr.get(index), s[i]);
        }

        // output int[]
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < arr.get(i).size(); j++) {
                s[count] = arr.get(i).get(j);
                count++;
            }
        }
    }

    /**
     * 加入桶并且排

     * @param l
     * @param v
     */
    public static void add(List<Integer> l, int v) {
        int index = -1;
        if (l.size() == 1 && v < l.get(0)) {
            index = 0;
        } else {
            for (int i = 1; i < l.size(); i++) {
                if (v >= l.get(i - 1) && v <= l.get(i)) {
                    index = i;
                }
            }
        }
        if (index != -1) {
            l.add(index, v);
        } else {
            l.add(v);
        }
    }

    public static void main(String[] args) {
        int[] a = { 24, 12, 13, 22, 17, 9, 19, 14, 88, 7 };
        BucketSort.sort(a, 2);
        LogUtil.log(a);
    }
}
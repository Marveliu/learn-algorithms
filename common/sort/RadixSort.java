import java.util.*;
import java.lang.*;

// 基数排序
class RadixSort {

    /**
     * @param s
     * @param max_len 最大位数
     */
    public static void sort(int[] s, int max_len) {
        for (int i = 0; i < max_len; i++) {
            int len = s.length;
            // statble bubble sort
            while (len >= 0) {
                for (int n = 1; n < len; n++) {
                    if (getAt(s[n], i) > getAt(s[n - 1], i)) {
                        int tmp = s[n];
                        s[n] = s[n - 1];
                        s[n - 1] = tmp;
                    }
                }
                len--;
            }
        }
    }

    /**
     * 获得指定位的值
     * 
     * @param t
     * @param i from 0
     * @return
     */
    public static int getAt(int t, int i) {
        String s = String.valueOf(t);
        if (i < s.length() && i >= 0) {
            return Integer.parseInt(String.valueOf(s.charAt(s.length() - i - 1)));
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] a = { 124, 12, 312, 232, 116, 923, 101, 14, 8, 17 };
        RadixSort.sort(a, 3);
        LogUtil.log(a);
    }

}
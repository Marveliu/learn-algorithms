// 快排
// 比较排序
// 时间复杂度:o(nlogn)
// 空间复杂度:o(1)

class QuickSort {

    /**
     * 快排
     * 
     * @param s 被排序的数组
     * @param p 排序上标 0
     * @param r 排序下标 length
     * @return
     */
    public static void quickSort(int[] s, int p, int r) {
        if (p < r) {
            int q = partition(s, p, r);
            // q 为分割点，不会再参与排序
            quickSort(s, p, q);
            quickSort(s, q + 1, r);
        }
    }

    /**
     * 划分并排序
     * 
     * @param s
     * @param p
     * @param r
     * @return 返回排序分割点
     */
    private static int partition(int[] s, int p, int r) {
        int key = s[r - 1];
        int i = p - 1;
        int j = p;
        for (; j < r - 1; j++) {
            if (s[j] <= key) {
                i++;
                int temp = s[j];
                s[j] = s[i];
                s[i] = temp;
            }
        }
        s[r - 1] = s[i + 1];
        s[i + 1] = key;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] a = { 100, 2, 11, 7, 6, 12, 98, 3 };
        QuickSort.quickSort(a, 0, a.length);
        LogUtil.log(a);
    }

}
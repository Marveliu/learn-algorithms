class HeapSort {

    /**
     * 获得左子节点
     * 
     * @param s 数组
     * @param i 父节点下标
     * @return
     */
    private static Integer getLeft(int i) {
        return 2 * i;
    }

    private static Integer getRight(int i) {
        return 2 * i + 1;
    }

    /**
     * 调整
     * 
     * @param s
     * @param len 长度，从1开始
     * @param i   下标
     */
    private static void max_heapify(int[] s, int len, int i) {
        int max;
        int parent = s[i];
        int l = getLeft(i);
        int r = getRight(i);
        if (l < len && s[l] >= s[i]) {
            max = l;
        } else {
            max = i;
        }
        if (r < len && s[r] >= s[max]) {
            max = r;
        }
        if (max != i) {
            int tmp = s[i];
            s[i] = s[max];
            s[max] = tmp;
            max_heapify(s, len, max);
        }
    }

    /**
     * 构建最大堆
     * 
     * @param s
     */
    private static void buildMaxHeap(int[] s) {
        int p = s.length / 2;
        while (p > 0) {
            max_heapify(s, s.length, p - 1);
            p--;
        }
    }

    /**
     * heap sort
     * 
     * @param s
     */
    public static void heapSort(int[] s) {
        buildMaxHeap(s);
        int len = s.length;
        int p = len - 1;
        // 不断取堆顶
        while (p > 0) {
            int tmp = s[0];
            s[0] = s[p];
            s[p] = tmp;
            max_heapify(s, --len, 0);
            p--;
        }
    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        HeapSort.heapSort(a);
        LogUtil.log(a);
    }

}
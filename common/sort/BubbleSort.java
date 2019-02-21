// 冒泡排序
// 稳定
// 时间复杂度：o(n^2)
// 空间复杂度：o(1)
class BubbleSort {

    public static void sort(int[] s) {
        int len = s.length;
        if (len <= 1)
            return;
        while (len > 1) {
            for (int i = 1; i < len; i++) {
                if (s[i] < s[i - 1]) {
                    int tmp = s[i];
                    s[i] = s[i - 1];
                    s[i - 1] = tmp;
                }
            }
            len--;
        }
    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        BubbleSort.sort(a);
        LogUtil.log(a);
    }

}
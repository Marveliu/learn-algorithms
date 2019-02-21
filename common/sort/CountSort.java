// 计数排序
// 非比较排序
// 时间复杂度：o(n)
// 空间复杂度：o(n)
class CountSort {

    public static int[] sort(int[] s, int top) {

        int[] t = new int[top + 1];
        int[] d = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            t[s[i]]++;
        }

        for (int i = 1; i < top + 1; i++) {
            t[i] = t[i] + t[i - 1];
        }

        for (int i = s.length - 1; i >= 0; i--) {
            d[t[s[i]] - 1] = s[i];
            t[s[i]]--;
        }

        return d;

    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
        LogUtil.log(CountSort.sort(a, 16));
    }

}
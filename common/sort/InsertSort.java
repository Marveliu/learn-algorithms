// 插入排序实现， 从小到大

class InsertSort {

    static int[] cal(int[] source) {
        for (int j = 1, i = 0; j < source.length; j++) {
            int key = source[j];
            i = j - 1;
            while (i >= 0 && source[i] > key) {
                source[i + 1] = source[i];
                i--;
            }
            source[i + 1] = key;
        }

        return source;
    }

    public static void main(String[] args) {
        LogUtil.log();
        int[] t = { 31, 41, 59, 26, 41, 58 };
        t = InsertSort.cal(t);
        LogUtil.log(t);
    }
}
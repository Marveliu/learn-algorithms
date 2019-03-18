// 快排
// 比较排序
// 时间复杂度:o(nlogn)
// 空间复杂度:o(1)

public class Solution {

    // 递归实现
    private void quickSort1(int[] n, int start, int end) {
        if (start < end) {
            int index = partition(n, start, end);
            quickSort1(n, start, index - 1);
            quickSort2(n, index + 1, end);
        }
    }

    // 非递归实现
    private void quickSort2(int[] n, int start, int end) {
        Deque<Integer> stack = new ArrayDeque<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(n, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }

    public int partition(int[] n, int s, int e) {
        int key = n[e];
        int i = s - 1;
        int j = s;
        for (; j < e; j++) {
            if (n[j] <= key) {
                i++;
                int tmp = n[j];
                n[j] = n[i];
                n[i] = tmp;
            }
        }
        n[e] = n[i + 1];
        n[i + 1] = key;
        return i + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            int[] n = StringUtil.getIntArr(sc);
            s.quickSort1(n, 0, n.length - 1);
            System.out.println(Arrays.toString(n));
        }
    }
}
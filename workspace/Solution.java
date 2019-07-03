import java.util.*;

public class Solution {

    public void quicksort(int[] n, int s, int e) {
        if (s < e) {
            int index = partition(n, s, e);
            quicksort(n, s, index - 1);
            quicksort(n, index + 1, e);
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
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int[] n = StringUtil.getIntArr(sc);
            s.quicksort(n, 0, n.length - 1);
            System.out.println(Arrays.toString(n));
        }
    }
}

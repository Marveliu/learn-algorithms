import java.util.*;
import java.io.*;

/**
 * 求无序数组的中位数
 * 
 * 基于快排进行改进
 * 
 * https://www.nowcoder.com/questionTerminal/2364ff2463984f09904170cf6f67f69a
 */
public class Main {
    static Scanner sc = null;

    public static int findMiddle(int[] n, int k) {
        int len = n.length;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(len - 1);
        stack.push(0);
        while (!stack.isEmpty()) {
            int s = stack.pop();
            int e = stack.pop();
            int index = partition(n, s, e);
            if (index == k) {
                return n[index];
            }
            if (index > s) {
                stack.push(index - 1);
                stack.push(s);
            }
            if (index < e) {
                stack.push(e);
                stack.push(index + 1);
            }
        }
        return -1;
    }

    public static int partition(int[] n, int s, int e) {
        int key = n[e];
        int i = s;
        int j = s - 1;
        for (; i < e; i++) {
            if (n[i] < key) {
                j++;
                int tmp = n[i];
                n[i] = n[j];
                n[j] = tmp;
            }
        }
        j++;
        n[e] = n[j];
        n[j] = key;
        return j;
    }

    public static void main(String[] args) {
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = 0;
            if (n % 2 != 0) {
                ans = findMiddle(arr, n / 2);
            } else {
                ans = (int) ((findMiddle(arr, n / 2) + findMiddle(arr, (n - 1) / 2)) / 2);
            }
            System.out.println(ans);
        }
    }

    static {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("testCases.txt"));
            sc = new Scanner(in);
        } catch (Exception e) {
            sc = new Scanner(System.in);
        }
    }
}

import java.util.*;

// [编程题] 字母交换
// dfs+回溯
public class Solution {

    int ans = Integer.MIN_VALUE;

    public int swap(String s, int num) {
        if (s == null || s.isEmpty())
            return 0;
        int[] v = new int[s.length()];
        ans = Integer.MIN_VALUE;
        dfs(s.toCharArray(), num, v);
        return ans;
    }

    public void dfs(char[] cs, int num, int[] v) {
        if (num <= 0) {
            ans = Math.max(ans, count(cs));
            return;
        }
        for (int i = 0; i < v.length - 1; i++) {
            // 回溯
            if (cs[i] != cs[i + 1] && v[i] == 0) {
                v[i] = 1;
                swap(cs, i, i + 1);
                dfs(cs, num - 1, v);
                swap(cs, i, i + 1);
                v[i] = 0;
            }
        }
    }

    public void swap(char[] cs, int p1, int p2) {
        char tmp = cs[p1];
        cs[p1] = cs[p2];
        cs[p2] = tmp;
    }

    public int count(char[] cs) {
        int max = 0;
        int sum = 1;
        for (int i = 1; i < cs.length; i++) {
            if (cs[i - 1] == cs[i]) {
                sum++;
            } else {
                sum = 1;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void Solution(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String[] in = sc.nextLine().split(" ");
            System.out.println(s.swap(in[0], Integer.valueOf(in[1])));
        }
    }
}
// abcbaa 2
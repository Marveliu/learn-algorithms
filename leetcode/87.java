import java.util.*;

// 1 2        1 / 1 = 1 ...0
// 2 1        2 / 1 = 2 ...0

// [1,2,3]
// 1 2 3      1 / 2 = 0 ...1
// 1 3 2      2 / 2 = 1 ...0
// 2 1 3      3 / 2 = 1 ...1
// 2 3 1      4 / 2 = 2 ...0

// [1,2,3,4]
// 1 2 3 4      1 / 6 = 0 ... 1
// 1 2 4 3      2 / 6 = 0 ... 2
// 1 3 2 4      3 / 6 = 0 ... 3
// 1 3 4 2      4 / 6 = 0 ... 4
// 1 4 2 3      5 / 6 = 0 ... 5
// 1 4 3 2      6 / 6 = 1 ... 0

// 3 * 2 * 1排列组合
// 9 % （ 3 * 2） = 3
// 3 % （ 2 * 1） = 1
// 递归 123 456 - 333

// 2 1 3 4      7 / 6 = 1 ... 1
// 2 1 4 3      8 / 6 = 1 ... 2
// 2 3 1 4      9 / 6 = 1 ... 3
// 2 3 4 1      10 / 6 = 1 ... 4

// 60. Permutation Sequence
// 思路：尾递归
public class Solution {

    public String getPermutation(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        return dfs(arr, k);
    }

    public String dfs(List<Integer> arr, int k) {
        if (arr.size() == 0) {
            return "";
        }
        if (k == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = arr.size() - 1; i >= 0; i--) {
                sb.append(arr.get(i));
            }
            return sb.toString();
        }

        // 当前可能组合的情况
        int multi = 1;
        for (int i = 1; i < arr.size(); i++) {
            multi *= i;
        }
        // present index will be token.
        int rem = k / multi;
        int mod = k % multi;
        int tmp = 0;
        if (mod == 0) {
            tmp = arr.get(rem - 1);
            arr.remove(rem - 1);
        } else {
            tmp = arr.get(rem);
            arr.remove(rem);
        }
        return String.valueOf(tmp) + dfs(arr, mod);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            sc.nextLine();
            int k = sc.nextInt();
            System.out.println(s.getPermutation(n, k));
        }
    }
}

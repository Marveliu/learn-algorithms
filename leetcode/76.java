import java.util.*;

// 72. Edit Distance
// https://leetcode.com/problems/edit-distance/
// 思路：dp
public class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // minimum cost (or steps) required to convert first i characters of word1 to
        // first j characters of word2
        int[][] cost = new int[m + 1][n + 1];

        // base f(0, k) = f(k, 0) = k
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    // Case 1: word1[i] == word2[j], i.e. the ith the jth character matches.
                    cost[i + 1][j + 1] = cost[i][j];
                } else {
                    // Case 2: word1[i] != word2[j], then we must either insert, delete or replace,
                    // whichever is cheaper
                    // f(i, j) = 1 + min { f(i, j - 1), f(i - 1, j), f(i - 1, j - 1) }
                    // f(i, j - 1) represents insert operation
                    // f(i - 1, j) represents delete operation
                    // f(i - 1, j - 1) represents replace operation
                    int a = cost[i][j];
                    int b = cost[i][j + 1];
                    int c = cost[i + 1][j];
                    int min = Math.min(a, Math.min(b, c));
                    cost[i + 1][j + 1] = min;
                    cost[i + 1][j + 1]++;
                }
            }
        }
        return cost[m][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");

            System.out.println(s.minDistance(sc.nextLine(), sc.nextLine()));
        }
    }
}

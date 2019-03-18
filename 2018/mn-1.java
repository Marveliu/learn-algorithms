import java.util.*;
import java.io.*;

public class Main {
    static Scanner sc = null;

    static List<String> ans = null;

    static int path = Integer.MAX_VALUE;

    static void dfs(int root, int k, int n, List<String> list, int sum) {
        if (k == 0 && n == 0) {
            if (sum < path) {
                path = sum;
                ans = list;
                return;
            }
        }
        if (k < 0)
            return;
        String add = root + " +";
        String remove = root + " -";
        List<String> adds = new ArrayList<>(list);
        List<String> removes = new ArrayList<>(list);
        adds.add(add);
        removes.add(remove);
        sum += root;
        dfs(root * 2, k - 1, n - root, adds, sum);
        dfs(root * 2 + 1, k - 1, n - root, adds, sum);
        dfs(root * 2, k - 1, n + root, removes, sum);
        dfs(root * 2 + 1, k - 1, n + root, removes, sum);
    }

    public static void main(String[] args) {
        while (sc.hasNext()) {
            ans = null;
            path = Integer.MAX_VALUE;
            int n = sc.nextInt();
            int k = sc.nextInt();
            dfs(1, k, n, new ArrayList<>(), 0);
            for (String var : ans) {
                System.out.println(var);
            }
        }
    }

    static {
        try {
            // local test
            BufferedInputStream in = new BufferedInputStream(new FileInputStream("testCases.txt"));
            sc = new Scanner(in);
        } catch (Exception e) {
            sc = new Scanner(System.in);
        }
    }

}

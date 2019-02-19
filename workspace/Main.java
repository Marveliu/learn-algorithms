import java.util.*;

public class Main {

    // 计数排序
    public int get(List<String> arr, int m, int c) {
        int[] count = new int[c];
        for (String var : arr) {
            int[] lines = arr.stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            for (int i = 1; i < lines.length; i++) {
                count[lines[i] - 1]++;
            }
        }
        int ans = 0;
        for (int var : count) {
            if (var == c)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Main s = new Main();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            int m = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextLine());
            }
            System.out.println(s);
        }
    }
}
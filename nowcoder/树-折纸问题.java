import java.util.*;

/**
 *
 *  https://www.nowcoder.com/test/question/430180b66a7547e1963b69b1d0efbd3c?pid=425653&tid=22370311
 */
public class Solution {

    public String[] foldPaper(int n) {
        List<String> ans = new ArrayList<>();
        inorder(1, n, true, ans);
        return ans.stream().toArray(String[]::new);
    }

    public void inorder(int i, int n, boolean down, List<String> ans) {
        if (i > n)
            return;
        inorder(i + 1, n, true, ans);
        ans.add((down ? "down" : "up"));
        inorder(i + 1, n, false, ans);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(Arrays.toString(s.foldPaper(sc.nextInt())));
        }
    }
}
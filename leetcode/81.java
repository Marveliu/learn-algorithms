import java.util.*;

// 67. Add Binary
public class Solution {

    public String addBinary(String a, String b) {
        Integer n = 0;
        int mlen = Math.max(a.length(), b.length());
        int[] ans = new int[mlen];
        for (int i = 0; i < mlen; i++) {
            int ai = a.length() - i - 1;
            int bi = b.length() - i - 1;
            int an = (ai >= 0 ? (a.charAt(ai) == '0' ? 0 : 1) : 0);
            int bn = (bi >= 0 ? (b.charAt(bi) == '0' ? 0 : 1) : 0);
            int added = an + bn + n;
            if (added > 1) {
                ans[i] = added - 2;
                n = 1;
            } else {
                ans[i] = added;
                n = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (n != 0) {
            sb.append("1");
        }
        for (int i = mlen - 1; i >= 0; i--) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String a = sc.nextLine();
            String b = sc.nextLine();
            System.out.println(s.addBinary(a, b));
        }
    }
}
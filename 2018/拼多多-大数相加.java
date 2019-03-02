import java.util.*;

// 大数相加
public class Solution {

    static void add(String s1, String s2) {
        int maxlen = Math.max(s1.length(), s2.length());
        int[] ans = new int[maxlen + 1];
        int i = 0;
        int carry = 0;
        while (i < maxlen) {
            int i1 = s1.length() - i - 1, i2 = s2.length() - i - 1;
            int n1 = 0, n2 = 0;
            if (i1 >= 0 && i1 < s1.length()) {
                n1 = s1.charAt(i1) - '0' + carry;
            }
            if (i2 >= 0 && i2 < s2.length()) {
                n2 = s2.charAt(i2) - '0';
            }
            int multi = n1 + n2;
            ans[i] = multi % 10;
            carry = multi / 10;
            i++;
        }
        ans[i] = carry;
        StringBuilder sb = new StringBuilder();
        for (; i >= 0; i--) {
            if (sb.length() == 0 && ans[i] == 0) {
                continue;
            }
            sb.append(ans[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            String[] ss = sc.nextLine().split(" ");
            add(ss[0], ss[1]);
        }
    }
}

// 123 2
//
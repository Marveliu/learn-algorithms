import java.util.*;


/**
 * 93. Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/
 * 
 * 给定数字，判断可能代表的IP地址
 * dfs
 */
public class Solution {

    List<String> ans = null;

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12)
            return ans;

        getIp("", s, 0);
        return ans;
    }

    public void getIp(String ip, String s, int count) {
        if (count == 4 && s.isEmpty()) {
            ans.add(ip);
            return;
        }
        if (!ip.isEmpty())
            ip = ip + ".";
        if (!s.isEmpty()) {
            for (int i = 1; i <= Math.min(3, s.length()); i++) {
                String now = s.substring(0, i);
                if (isIp(now)) {
                    getIp(ip + now, s.substring(i, s.length()), count + 1);
                }
            }
        }
    }

    public static boolean isIp(String s) {
        if (s.length() <= 3) {
            if (s.length() > 1 && s.startsWith("0")) {
                return false;
            }
            int n = Integer.valueOf(s);
            if (n >= 0 && n <= 255) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            List<String> ans = s.restoreIpAddresses(in);
            System.out.println(Arrays.toString(ans.toArray()));
        }
    }
}

// 010010
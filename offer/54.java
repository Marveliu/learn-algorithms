import java.util.*;
// 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
// 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
public class Solution {

    // 可以考虑使用int[256] 反正char占8位 最大只有256
    Map<Character, Integer> map = new LinkedHashMap<>();

    // Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> var : map.entrySet()) {
            if (var.getValue() == 1)
                return var.getKey();
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            char[] test = in.toCharArray();
            for (int i = 0; i < test.length; i++) {
                s.Insert(test[i]);
                System.out.println(s.FirstAppearingOnce());
            }
        }
    }
}

// google
// g
// g
// g
// #
// l
// l
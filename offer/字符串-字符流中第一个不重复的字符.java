import java.util.*;

/**
 * 字符流中第一个不重复的字符
 * 
 * https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720
 * 
 */
public class Solution {

    // 可以考虑使用int[256] 反正char占8位 最大只有256
    Map<Character, Integer> map = new LinkedHashMap<>();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

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
import java.util.*;

/**
 * 第一个只出现一次的字符
 * 
 * 思路:
 * LinkedHashMap 默认按照插入的顺序进行排序
 * 
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c
 */
public class Solution {

    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] cs = str.toCharArray();
        for (char c : cs) {
            Integer v = map.putIfAbsent(c, 1);
            if (v != null) {
                map.put(c, v + 1);
            }
        }
        for (Map.Entry<Character, Integer> var : map.entrySet()) {
            if (var.getValue() == 1) {
                return str.indexOf(var.getKey().toString());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int test = s.FirstNotRepeatingChar(in);
            System.out.println(test);
        }
    }
}
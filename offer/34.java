import java.util.*;

// 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
// 近视o(n)解法，linkedHashMap底层实现 数组加双向链表的方式解决哈希碰撞，存在header指向双向链表，遍历的顺序就是加入元素的顺序 https://github.com/CarpenterLee/JCFInternals/blob/master/markdown/7-LinkedHashSet%20and%20LinkedHashMap.md
public class Solution {

    public int FirstNotRepeatingChar(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] cs = str.toCharArray();
        for (char c : cs) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
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
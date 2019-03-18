import java.util.*;

/**
 * 12. Integer to Roman
 * 
 * https://leetcode.com/problems/integer-to-roman/
 * 
 * 贪心
 */
public class Solution {

    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
        int[] n = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            for (int i = n.length - 1; i >= 0; i--) {
                if (n[i] <= num && (i + 1 >= n.length || n[i + 1] > num)) {
                    sb.append(map.get(n[i]));
                    num -= n[i];
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            System.out.println(s.intToRoman(sc.nextInt()));
        }
    }
}
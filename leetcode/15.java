import java.util.*;
// 136. Single Number
// Given a non-empty array of integers, every element appears twice except for one. Find that single one
// 思路:位运算
public class Solution {

    public int singleNumber(int[] A) {
        int s2 = 0;
        for (int var : A) {
            s2 = s2 ^ var;
        }
        return s2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(1 ^ 1);
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int[] test = Arrays.stream(in.split(",")).mapToInt(item -> Integer.valueOf(item)).toArray();
            System.out.println(s.singleNumber(test));
        }
    }
}
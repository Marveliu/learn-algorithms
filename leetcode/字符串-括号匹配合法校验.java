import java.util.*;

/**
 * 20. Valid Parentheses
 * 
 * https://leetcode.com/problems/valid-parentheses/submissions/
 * 
 */
public class Solution {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty())
            return true;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && isPair(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public boolean isPair(Character c1, Character c2) {
        if ((c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']')) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.isValid(sc.nextLine()));
        }
    }
}
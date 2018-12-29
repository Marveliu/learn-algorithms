import java.util.*;
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are+,-,*,/. Each operand may be an integer or another expression.
// Some examples:

// stack
public class Solution {

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String tmp = tokens[i];
            if (isNum(tmp)) {
                ll.add(Integer.valueOf(tmp));
                continue;
            }
            // if(ll.size() <2) error
            int a = ll.pollLast();
            int b = ll.pollLast();
            if (tmp.equals("+")) {
                ll.add(a + b);
            } else if (tmp.equals("-")) {
                ll.add(b - a);
            } else if (tmp.equals("*")) {
                ll.add(a * b);
            } else {
                // "/"
                ll.add(b / a);
            }
        }
        return ll.pollLast();
    }

    boolean isNum(String s) {
        char[] c = s.toCharArray();
        if (c.length == 0)
            return false;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '+' || c[i] == '-') {
                if (i != 0 || s.length() == 1) {
                    return false;
                }
                continue;
            }
            if (c[i] < '0' || c[i] > '9') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            String[] test = in.split(",");
            int ans = s.evalRPN(test);
            System.out.println(ans);
        }
    }
}
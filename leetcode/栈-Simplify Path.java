import java.util.*;

/**
 * 71. Simplify Path
 * https://leetcode.com/problems/simplify-path/
 * 
 * 思路：stack
 * 注意： /...的情况
 */
public class Solution {

    public String simplifyPath(String path) {
        Deque<Character> stack = new ArrayDeque<>();
        String p = path + "/";
        for (int i = 0; i < p.length(); i++) {
            Character peek = stack.peek();
            char now = p.charAt(i);
            if (peek == null) {
                stack.push(now);
                continue;
            }
            if (now == '/') {
                if (stack.peek() == '.') {
                    stack.pop();
                    if (stack.peek() == '.') {
                        // pop '/ * /../'
                        stack.pop();
                        if (stack.size() != 1) {
                            if (stack.peek() == '/') {
                                stack.pop();
                                while (stack.peek() != '/') {
                                    stack.pop();
                                }
                            } else {
                                stack.push('.');
                                stack.push('.');
                            }
                        }
                    }
                    continue;
                } else if (stack.peek() == '/') {
                    continue;
                }
            }
            stack.push(now);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            if (stack.size() == 1) {
                if (stack.peek() == '/' && sb.length() != 0) {
                    break;
                }
            }
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            System.out.println(s.simplifyPath(in));
        }
    }
}

// * / -> *
// * / . / -> * pop
// */ B / . . -> * pop 3
// */ / -> *

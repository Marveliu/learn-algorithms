import java.util.*;

/**
 * 用两个栈实现队列
 * stack1 负责压栈
 * stack2 负责出队列，出队列的时候，弹出所有的stack1元素，并且重新压入stack2
 * 
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6
 */
public class Solution {

    // push
    Stack<Integer> stack1 = new Stack<Integer>();
    // pop
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        // 将stack1重新入栈stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int type = sc.nextInt();
            sc.nextLine();
            switch (type) {
            case 1: {
                s.push(sc.nextInt());
                sc.nextLine();
                break;
            }
            case 2: {
                System.out.print("pop:");
                System.out.println(s.pop());
                break;
            }
            default: {
                System.out.println("input 1 push or 2 pop");
            }
            }
        }
    }
}

// Input>>>
// 1
// 2
// Input>>>
// 1
// 3
// Input>>>
// 2
// pop:2
// Input>>>
// 2
// pop:3
// Input>>>
// 2
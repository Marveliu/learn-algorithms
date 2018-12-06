import java.util.*;
// 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
public class Solution {

    // impl...
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            Integer tmp = stack1.pop();
            stack2.push(tmp);
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        // test...
    }
}
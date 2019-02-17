import java.util.*;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 
 * https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49
 */
public class Solution {

    Integer min = Integer.MAX_VALUE;
    Stack<Integer> s1 = new Stack<>();
    // s2 stack 维护每次push pop的最小值
    Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        s1.push(node);
        if (node <= min) {
            min = node;
        }
        // 永远存放当前最小值
        s2.push(min);
    }

    public void pop() {
        s1.pop();
        s2.pop();
        min = s2.peek();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(3);
        LogUtil.log(s.min());
        s.push(4);
        LogUtil.log(s.min());
        s.push(2);
        LogUtil.log(s.min());
        s.push(3);
        LogUtil.log(s.min());
        s.pop();
        LogUtil.log(s.min());
        s.pop();
        LogUtil.log(s.min());
        s.pop();
        LogUtil.log(s.min());
        s.push(0);
        LogUtil.log(s.min());
    }
}
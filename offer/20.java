import java.util.*;

// 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

public class Solution {

    // 1. sort性能太低， 考虑一下线程安全的实现
    // volatile int top = -1;
    // Integer min = Integer.MAX_VALUE;
    // Vector<Integer> v = new Vector<Integer>();

    // public void push(int node) {
    // synchronized (v) {
    // top++;
    // v.add(node);
    // sort();
    // }
    // synchronized (min) {
    // sort();
    // }
    // }

    // public void pop() {

    // if (top != -1) {
    // v.remove(top);
    // top--;
    // }
    // synchronized (min) {
    // sort();
    // }
    // }

    // public int top() {
    // return top >= 0 ? v.get(top) : 0;
    // }

    // public int min() {
    // return min == null ? 0 : min;
    // }

    // public void sort() {
    // min = Integer.MAX_VALUE;
    // for (int index = 0; index < v.size(); index++) {
    // if (v.get(index) <= min) {
    // min = v.get(index);
    // }
    // }
    // }

    // s2 stack 维护每次push pop之后的最小值
    Integer min = Integer.MAX_VALUE;
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(int node) {
        s1.push(node);
        if (node <= min) {
            min = node;
        }
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
        // test...
    }
}
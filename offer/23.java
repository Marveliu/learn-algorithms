import java.util.*;

// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
// 利用二叉树的性质，左小右大，递归一下就好，但是要注意递归的步骤，不要简单问题复杂化
public class Solution {

    // public boolean VerifySquenceOfBST(int[] sequence) {
    // int len = sequence.length;
    // if (len == 1)
    // return true;
    // if (len == 0)
    // return false;
    // int index = 0;
    // for (; index < len - 1; index++) {
    // if (sequence[index] > sequence[len - 1])
    // break;
    // }
    // return check(sequence, 0, index - 1, index, true) && check(sequence, index,
    // len - 2, len - 1, false);
    // }

    // public boolean check(int[] sequence, int s, int e, int p, boolean isLeft) {
    // if (s >= e)
    // return true;
    // for (int index = s; index <= e; index++) {
    // if (sequence[index] > sequence[p] && isLeft) {
    // return false;
    // }
    // if (sequence[index] < sequence[p] && !isLeft) {
    // return false;
    // }
    // }
    // int index = s;
    // for (; index < e; index++) {
    // if (sequence[index] > sequence[e])
    // break;
    // }
    // return check(sequence, s, index - 1, index, true) && check(sequence, index, e
    // - 1, e, false);
    // }

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0)
            return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    public boolean isBST(int[] t, int s, int e) {
        if (s > e)
            return true;
        int index = s;
        int root = t[e];
        for (; index < e; index++) {
            if (t[index] > root) {
                break;
            }
        }
        for (int i = index; i < e; i++) {
            if (t[i] < root)
                return false;
        }
        return isBST(t, s, index - 1) && isBST(t, index, e - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // int[] test = { 2, 5, 4, 7, 9, 8, 6 };
        int[] test = { 1, 42, 3, 2 };
        LogUtil.log(s.VerifySquenceOfBST(test));
        // test...
    }
}
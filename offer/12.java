import java.util.*;

// 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public class Solution {

    // impl...
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return cal(1 / base, (-1) * exponent);
        }
        return cal(base, exponent);
    }

    // 1. 普通实现
    // public double cal(double base, int ex) {
    // double tmp = base;
    // while (ex != 1) {
    // base = base * tmp;
    // ex--;
    // }
    // return base;
    // }

    // 2. 注意移位运算是针对整数的，因为小数存储的方式都是科学计数法，补充一下，负数二进制是其补码，取正取反加1
    public double cal(double base, int ex) {
        double res = 1;
        double current = 1;
        while ((ex != 0)) {
            current = current * base;
            if ((ex & 1) == 1) {
                res = res * current;
            }
            ex = ex >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        LogUtil.log(s.Power(2, -2));
        // test...
    }
}
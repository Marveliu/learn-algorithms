import java.util.*;

/**
 * 数值的整数次方
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 位运损
 * 
 * https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00
 */
public class Solution {

    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return cal(1 / base, (-1) * exponent);
        }
        return cal(base, exponent);
    }

    // 1. 遍历
    // public double cal(double base, int ex) {
    //     double tmp = base;
    //     while (ex != 1) {
    //         base = base * tmp;
    //         ex--;
    //     }
    //     return base;
    // }

    // 优化求方，按照二级制位数进行分解
    // 3^3 = 3^2*3^1 3的二进制 11
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
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.Power(sc.nextDouble(), sc.nextInt()));
        }
    }
}
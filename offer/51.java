import java.util.*;

import sun.security.util.Length;
// 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

public class Solution {

    public int[] multiply(int[] A) {
        // special
        int len = A.length;
        int[] B = new int[len];
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            B[i] = tmp[i] = 1;
        }
        // 主要简化 x+y = len-1, x与y是对称的
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
            tmp[len - i - 1] = tmp[len - i] * A[len - i];
        }

        // for (int i = len - 2; i >= 0; i--) {
        // tmp[i] = tmp[i + 1] * A[i + 1];
        // }

        for (int i = 0; i < len; i++) {
            B[i] = B[i] * tmp[i];
        }
        return B;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            int[] ans = s.multiply(test);
            for (int var : ans) {
                System.out.println(var);
            }
        }
    }
}

// Input>>>
// 1,2,3
// 6
// 3
// 2
// Input>>>
// 4,5,6
// 30
// 24
// 20
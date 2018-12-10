import java.util.*;

// 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。

public class Solution {

    // Map方式处理
    // public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
    // Map<Integer, Integer> map = new LinkedHashMap<>();
    // for (int var : array) {
    // if (map.containsKey(var)) {
    // map.put(var, map.get(var) + 1);
    // } else {
    // map.put(var, 1);
    // }
    // }
    // Boolean flag = true;
    // for (Map.Entry<Integer, Integer> var : map.entrySet()) {
    // if (var.getValue() % 2 != 0) {
    // if (flag) {
    // num1[0] = var.getKey();
    // flag = false;
    // } else {
    // num2[0] = var.getKey();
    // }
    // }
    // }
    // }

    // n^n == 0, 0^n=0,
    // 因此对整个数组进行异或必然可以得到不为0的数，而这个数为1的最低位说明，这个两个数的二进制该位数值不同
    // 因此可以在二进制上进行划分，为1的num1[0],进行异或，不为0的和num2[0],注意num1和num2初始值为0
    // 
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            n ^= array[i];
        }
        int index = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                break;
            }
            index++;
            n = n >>> 1;
        }
        for (int var : array) {
            if (isBit1(var, index)) {
                num1[0] = num1[0] ^ var;
            } else {
                num2[0] = num2[0] ^ var;
            }
        }
    }

    boolean isBit1(int n, int index) {
        n = n >>> (index - 1);
        return (n & 1) == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            int[] n1 = { 0 };
            int[] n2 = { 0 };
            s.FindNumsAppearOnce(test, n1, n2);
            System.out.println(n1[0]);
            System.out.println(n2[0]);
        }
    }
}
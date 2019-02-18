import java.util.*;

/**
 * 数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 * 
 * https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811
 */
public class Solution {

    // Map方式处理
    // public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
    //     Map<Integer, Integer> map = new LinkedHashMap<>();
    //     for (int var : array) {
    //         if (map.containsKey(var)) {
    //             map.put(var, map.get(var) + 1);
    //         } else {
    //             map.put(var, 1);
    //         }
    //     }
    //     Boolean flag = true;
    //     for (Map.Entry<Integer, Integer> var : map.entrySet()) {
    //         if (var.getValue() % 2 != 0) {
    //             if (flag) {
    //                 num1[0] = var.getKey();
    //                 flag = false;
    //             } else {
    //                 num2[0] = var.getKey();
    //             }
    //         }
    //     }
    // }

    // n^n == 0, 0^n=0,
    // 因此对整个数组进行异或必然可以得到不为0的数，而这个数为1的最低位说明，这个两个数的二进制该位数值不同 因此可以在二进制上进行划分，
    // 异或的结果1所在的最低位，把数字分成两半，每一半里都还有只出现一次的数据和成对出现的数据，这样继续对每一半相异或则可以分别求出两个只出现一次的数字
    // 这个结果数字的二进制表示中至少就有一位为1 。我们在结果数字中找到第一个为1的位的位置，记为第N 位。现在我们以第N位是不是1为标准把原数组中的数字分成两个子数组
    // 第一个子数组中每个数字的第N位都为1，而第二个子数组的每个数字的第N位都为0 。
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
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            int[] n1 = { 0 };
            int[] n2 = { 0 };
            s.FindNumsAppearOnce(test, n1, n2);
            System.out.println(n1[0]);
            System.out.println(n2[0]);
        }
    }
}
import java.util.*;

// 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

public class Solution {

    // Parameters:
    // numbers: an array of integers
    // length: the length of array numbers
    // duplication: (Output) the duplicated number in the array number,length of
    // duplication array is 1,so using duplication[0] = ? in implementation;
    // Here duplication like pointor in C/C++, duplication[0] equal *duplication in
    // C/C++
    // 这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value: true if the input is valid, and there are some duplications in
    // the array number
    // otherwise false

    // 基数排序的变种，时间复杂度是o(n)
    // public boolean duplicate(int numbers[], int length, int[] duplication) {
    // if (numbers == null || numbers.length == 0)
    // return false;
    // // check[i] means count of i in numbers.
    // int[] check = new int[length];
    // for (int i = 0; i < numbers.length; i++) {
    // check[numbers[i]]++;
    // }
    // for (int i = 0; i < length; i++) {
    // if (check[i] > 1) {
    // duplication[0] = i;
    // return true;
    // }
    // }
    // return false;
    // }

    // 特点: length: the length of array num
    // ers，length刚好是number长度，又是取值范围，因此numbers本身可以当1. check[]辅助数组
    // 
    // 空间复杂度o(1)
    // 不需要额外的数组或者hash table来保存，题目里写了数组里数字
    // 范围保证在0 ~ n-1 之间，所以可以利用现有数组设置标志
    // 
    // ，当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
    // 
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            // 恢复原来的值，因为可能被其他的值记录存在
            if (index >= length) {
                index = index - length;
            }
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] numbers = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            int length = sc.nextInt();
            int[] ans = { -1 };
            if (s.duplicate(null, length, ans)) {
                System.out.println(ans[0]);
            }
        }
    }
}
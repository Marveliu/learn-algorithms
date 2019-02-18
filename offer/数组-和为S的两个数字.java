import java.util.*;
/*
 * 和为S的两个数字
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 思路: 
 * 
 * 1. 数学 (n-x)(n+x)>(n-x-1)(n+x+1) 在外围乘积小，最里面的乘积大
 * 2. 滑动窗口
 * 
 * https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b
 */
public class Solution {

    // 1. 夹逼，从外向内
    // public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     if (array.length == 0)
    //         return ans;
    //     int s = 0, e = array.length - 1;
    //     while (s < e) {
    //         int tmp = array[s] + array[e];
    //         if (tmp == sum) {
    //             ans.add(array[s]);
    //             ans.add(array[e]);
    //             break;
    //         } else if (tmp < sum) {
    //             s++;
    //         } else {
    //             e--;
    //         }
    //     }
    //     return ans;
    // }

    // 2. 滑动窗口，从内向外
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (array.length == 0)
            return ans;
        int mid = sum / 2;
        int s = 0;
        for (; array[s] < mid; s++) {
        }
        int e = s;
        int lmin = 0;
        int lmax = 0;
        while (s >= 0 && e < array.length) {
            int tmp = array[s] + array[e];
            if (tmp == sum) {
                ans.add(array[s]);
                ans.add(array[e]);
                break;
            } else if (tmp < sum) {
                e++;
            } else {
                s--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            int sum = sc.nextInt();
            ArrayList<Integer> res = s.FindNumbersWithSum(test, sum);
            for (Integer var : res) {
                System.out.println(var);
            }
        }
    }
}
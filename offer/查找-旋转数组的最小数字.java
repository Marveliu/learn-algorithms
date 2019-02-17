import java.util.*;

/**
 * 旋转数组的最小数字
 * 查找
 * 
 * case:
 * input: 3,4,5,1,2
 * output: 1,2,3,4,5
 * 
 * arr[i]<arr[i-1] i即为结果
 * 
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba
 */
public class Solution {

    public int minNumberInRotateArray(int[] array) {
        for (int index = 1; index < array.length; index++) {
            if (array[index] < array[index - 1]) {
                return array[index];
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.minNumberInRotateArray(StringUtil.getIntArr(sc)));
        }
    }
}
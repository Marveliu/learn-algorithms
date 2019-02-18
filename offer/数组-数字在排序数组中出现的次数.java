import java.util.*;

/**
 * 数字在排序数组中出现的次数
 * 数组特性
 * 
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2
 */
public class Solution {

    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
            }
            if (array[i] > k) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            int k = sc.nextInt();
            int res = s.GetNumberOfK(test, k);
            System.out.println(res);
        }
    }
}
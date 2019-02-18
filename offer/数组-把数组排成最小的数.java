import java.util.*;
import java.util.stream.Collectors;

/**
 * 把数组排成最小的数
 * 输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 
 * 思路:自定义比较器
 */
public class Solution {

    public String PrintMinNumber(int[] numbers) {
        List<Integer> ns = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        ns.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                int o1 = Integer.valueOf(i1.toString() + i2.toString());
                int o2 = Integer.valueOf(i2.toString() + i1.toString());
                return o1 - o2;
            }
        });
        for (Integer var : ns) {
            sb.append(var);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            String res = s.PrintMinNumber(test);
            System.out.println(res);
        }
    }
}
import java.util.*;

// 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
public class Solution {

    LinkedList<Double> lt = new LinkedList<>();

    public void Insert(Integer num) {
        int index = 0;
        if (lt.size() == 0) {
            lt.add(num * 1.0);
        } else {
            while (index < lt.size() && lt.get(index) <= num) {
                index++;
            }
            lt.add(index, num * 1.0);
        }
    }

    public Double GetMedian() {
        int len = lt.size();
        if (len % 2 == 0) {
            return (lt.get(len / 2) + lt.get(len / 2 - 1)) / 2;
        } else {
            return lt.get(len / 2);
        }
    }

    // TreeMap<Integer, Integer> t = new TreeMap<>();
    // public void Insert(Integer num) {
    // t.put(num, null);
    // }

    // public Double GetMedian() {
    // int len = t.size();
    // 很费时
    // double[] s = t.keySet().stream().mapToDouble(item ->
    // Double.valueOf(item)).toArray();
    // if (len % 2 == 0) {
    // return (s[len / 2] + s[len / 2 - 1]) / 2;
    // } else {
    // return s[(len) / 2];
    // }
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            for (int var : test) {
                s.Insert(var);
                Double ans = s.GetMedian();
                System.out.println(ans);
            }
            s.lt.clear();
        }
    }
}
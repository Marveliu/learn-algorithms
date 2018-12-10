import java.util.*;

// 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
// 2^x*3^y*5^z 维护a2,a3,a5三个优先队列,1364出出现问题，是因为精度的问题...用double
public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if (index == 0)
            return 0;
        ArrayList<Double> un = new ArrayList<>();
        PriorityQueue<Double> a2 = new PriorityQueue<>();
        PriorityQueue<Double> a3 = new PriorityQueue<>();
        PriorityQueue<Double> a5 = new PriorityQueue<>();

        un.add(Double.valueOf(1));
        un.add(Double.valueOf(2));
        un.add(Double.valueOf(3));
        un.add(Double.valueOf(4));
        un.add(Double.valueOf(5));

        int p = 0;

        while (index > 4 && p != index - 1) {
            // if (p == 1362) {
            // int a = 1;
            // System.out.println(a);
            // }
            Double tmp2 = un.get(p) * 2;
            Double tmp3 = un.get(p) * 3;
            Double tmp5 = un.get(p) * 5;

            if (!a2.contains(tmp2))
                a2.offer(tmp2);
            if (!a3.contains(tmp3))
                a3.offer(tmp3);
            if (!a5.contains(tmp5))
                a5.offer(tmp5);

            Double min = a2.peek();
            p++;

            if (min > a3.peek())
                min = a3.peek();
            if (min > a5.peek())
                min = a5.peek();
            if (min > 5)
                un.add(min);
            a2.remove(min);
            a3.remove(min);
            a5.remove(min);
        }
        return (int) un.get(index - 1).doubleValue();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int test = sc.nextInt();
            int res = s.GetUglyNumber_Solution(test);
            System.out.println(res);
        }
    }
}
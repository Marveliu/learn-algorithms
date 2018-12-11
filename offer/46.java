import java.util.*;

// Joseph Ring
public class Solution {

    // 1. 模拟
    // public int LastRemaining_Solution(int n, int m) {
    // if (n <= 0) {
    // return -1;
    // }
    // ArrayList<Integer> list = new ArrayList<>();
    // for (int i = 0; i < n; i++) {
    // list.add(i);
    // }
    // return Joseph(list, 0, m);
    // }

    // public int Joseph(List<Integer> list, int index, int m) {
    // if (list.size() == 1) {
    // return list.get(0);
    // }
    // int next = (index + m - 1) % list.size();
    // list.remove(next);
    // next = next > list.size() - 1 ? 0 : next;
    // return Joseph(list, next, m);
    // }

    // 2. 精简版本
    // public int LastRemaining_Solution(int n, int m) {
    // if (n <= 0) {
    // return -1;
    // }
    // LinkedList<Integer> list = new LinkedList<>();
    // for (int i = 0; i < n; i++) {
    // list.add(i);
    // }
    // int next = 0;
    // while (list.size() > 1) {
    // // 这个地方很巧妙
    // //
    // 第一次删掉的位置是从0开始数m-1个位置，以后每次从删掉的下一个节点开始取，所以每次要在bt的索引处加上m-1，
    // // 因为是环，所以加了以后对链表长度取余
    // next = (next + m - 1) % list.size();
    // list.remove(next);
    // }
    // return list.get(0);
    // }

    // 约瑟夫问题，求递推公式，每轮的序列中最后出序列的数都是同一个
    // f[1] = 0;
    // f[i] = (f[i - 1] + m) mod i;

    // 链接：https://www.nowcoder.com/questionTerminal/f78a359491e64a50bce2d89cff857eb6    

    // 中每次删除第m个数字最后剩下的数字。
    // 第一个被删除的数字（m-1）%n.
    // 例如0,1,2,3,4,5，删除第3个，即2，那么（3-1）%6=0….2,商0余2，所以2就是那个被删除的数。
    // 在删除第m个数字(定义为k)之后的序列为
    // 0,1,2，…k-1,k+1,…n-1;
    // 在进入下一次循环时删除第m个的时候从第k+1个数开始，这个序列为k+1，，，n-1,0,1,…k-1;函数因此定为f*(n-1,m)
    // 再将这个映射我从0开始的序列，如下：
    // K+2 → 1;
    // …
    // n-1 →   1-(k+1)=n-k-2;
    // 0 →   2+1=n-k-1;
    // 1 →   
    // …  
    // 映射p(x)=p(x-k-1)%n;表示映射钱的数字是x,映射后的数字是x-k-1。逆映射为
    // P*(x)=(x+k+1)%n.
    // 这里记住无论循环多少次删除第m个元素最后剩下的数字是一样的。
    // 有f*(n-1,m)=P*( f(n-1,m))=( f(n-1,m)+k+1)%n.=（f(n-1,m)+m）%n.
    // 因为k=(m-1)%n=(m-1)
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1)
            return -1;
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution(n - 1, m) + m) % n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            int m = sc.nextInt();
            int ans = s.LastRemaining_Solution(n, m);
            System.out.println(ans);
        }
    }
}
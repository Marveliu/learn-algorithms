import java.util.*;

/**
 * 滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 
 * 思路:堆实现，维护一个插入有序的链表，然后滑动窗口
 * 
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788
 */
public class Solution {

    LinkedList<Integer> lt = new LinkedList<>();

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (size > num.length || size == 0)
            return ans;
        for (int i = 0; i < size; i++) {
            add(num[i]);
        }
        int start = 0;
        int end = size - 1;
        ans.add(lt.get(0));
        while (end < num.length - 1) {
            lt.remove(Integer.valueOf(num[start]));
            start++;
            end++;
            add(num[end]);
            ans.add(lt.get(0));
        }
        return ans;
    }

    public void add(int n) {
        for (int i = 0; i < lt.size(); i++) {
            if (lt.get(i) < n) {
                lt.add(i, n);
                return;
            }
        }
        lt.add(n);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            int size = sc.nextInt();
            ArrayList<Integer> arr = s.maxInWindows(test, size);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
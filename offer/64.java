import java.util.*;

// 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
// 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
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
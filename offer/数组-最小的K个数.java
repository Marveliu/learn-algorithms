import java.util.*;
import java.util.stream.Collectors;

/**
 * 最小的K个数
 * 
 * 思路:
 * 1. 快排
 * 2. 堆
 * 3. 快速选择算法
 * 
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf
 */
public class Solution {

    // 1. quick sort nlogn
    // public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    //     ArrayList<Integer> res = new ArrayList<>();
    //     if (input.length < k)
    //         return res;
    //     Arrays.sort(input);
    //     for (int i = 0; i < k; i++) {
    //         res.add(input[i]);
    //     }
    //     return res;
    // }

    // 2. ProrityQueue本质是堆，offer, poll等操作都是logn，
    // 注意默认是自然的顺序，因此需要设置comparator构造大顶堆
    // 时间复杂度:O(nlogk),比较适合大规模数据
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input.length < k || k <= 0) {
            return res;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (i < k) {
                maxHeap.offer(input[i]);
                continue;
            }
            if (maxHeap.peek() > input[i]) {
                maxHeap.remove();
                maxHeap.offer(input[i]);
            }
        }
        while (maxHeap.peek() != null) {
            res.add(maxHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }

    // 3. 快速选择算法，最优o(n) {logn*logn}，最差情况是o(n^2)
    // 类似快排
    // public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    //     ArrayList<Integer> res = new ArrayList<>();
    //     if (input.length < k || k <= 0) {
    //         return res;
    //     }
    //     int start = 0;
    //     int end = input.length - 1;
    //     int index = partition(input, start, end);
    //     while (index != k - 1) {
    //         if (index > k - 1) {
    //             index = partition(input, start, index - 1);
    //         }
    //         if (index < k - 1) {
    //             index = partition(input, index + 1, end);
    //         }
    //     }
    //     res.addAll(Arrays.stream(Arrays.copyOf(input, k)).boxed().collect(Collectors.toList()));
    //     Collections.sort(res);
    //     return res;
    // }

    // public int partition(int[] input, int start, int end) {
    //     if (start > end) {
    //         return -1;
    //     }
    //     int key = input[end];
    //     int i = start;
    //     int j = i - 1;
    //     for (; i < end; i++) {
    //         if (input[i] <= key) {
    //             int tmp = input[j + 1];
    //             input[j + 1] = input[i];
    //             input[i] = tmp;
    //             j++;
    //         }
    //     }
    //     int tmp = input[j + 1];
    //     input[j + 1] = key;
    //     input[end] = tmp;
    //     return j + 1;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int[] test = Arrays.asList(sc.nextLine().split(",")).stream().mapToInt(item -> Integer.valueOf(item))
                    .toArray();
            int k = sc.nextInt();
            ArrayList<Integer> res = s.GetLeastNumbers_Solution(test, k);
            for (Integer var : res) {
                System.out.println(var);
            }
        }
    }
}

// 5,4,3,2,1
// 4
// 1
// 2
// 3
// 4
// Input>>>
// 2,2
// 3
// Input>>>
// 1,2,3
// 1
// 1
// Input>>>
// ,
// 1
import java.util.*;

/**
 * 347. Top K Frequent Elements
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * 维护小顶堆
 * 
 * 时间复杂度：o(nlogk)
 */
public class Solution {

    class Node {
        int k;
        int v;

        Node(int k, int v) {
            this.k = k;
            this.v = v;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.v - n2.v;
            }
        });
        Map<Integer, Node> map = new HashMap<>();
        for (int var : nums) {
            map.putIfAbsent(var, new Node(var, 0));
            map.get(var).v++;
        }
        for (Map.Entry<Integer, Node> item : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(item.getValue());
            } else {
                if (minHeap.peek().v < item.getValue().v) {
                    minHeap.poll();
                    minHeap.offer(item.getValue());
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (minHeap.size() != 0) {
            ans.add(minHeap.poll().k);
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
            int[] nums = StringUtil.getIntArr(sc);
            int k = sc.nextInt();
            sc.nextLine();
            System.out.println(Arrays.toString(s.topKFrequent(nums, k).toArray()));
        }
    }
}

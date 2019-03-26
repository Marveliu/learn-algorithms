import java.util.*;

/**
 * 406. Queue Reconstruction by Height
 * 
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * 
 * 1. 首先找到身高最高的人并对他们进行排序。
 * 2. 然后找到身高次高的人，按照他们的前面的人数把他们插入到最高的人群中。
 * 
 * 思路：贪心算法
 */
public class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                else
                    return a[1] - b[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            int[] peo = people[i];
            res.add(peo[1], peo);
        }
        return res.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Input>>>");
        }
    }
}
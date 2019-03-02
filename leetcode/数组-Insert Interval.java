import java.util.*;


/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/
 * 
 * 思路: dfs 也可以使用归并排序
 * 
 * 
 * 1. [2,4] [1,5] 包括
 * 2. [2,4] [1,3] 左重叠 [1,4]
 * 3. [2,4] [3,4] 右重叠 [2,4]
 * 4. [1,5] [2,3] 内含
 * 
 * 5. [2,4] [5,6] 不相关
 * 
 */
public class Solution {

    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null)
            return intervals;
        Interval merge = null;
        int i = 0;
        for (; i < intervals.size(); i++) {
            Interval now = intervals.get(i);
            // 重叠
            if ((now.start >= newInterval.start && now.start <= newInterval.end)
                    || (now.end >= newInterval.start && now.end <= newInterval.end)
                    || (now.start < newInterval.start && now.end > newInterval.end)) {
                int start = Math.min(now.start, newInterval.start);
                int end = Math.max(now.end, newInterval.end);
                merge = new Interval(start, end);
                break;
            }
            // 不相关
            int lm = (i - 1 < 0 ? Integer.MIN_VALUE : intervals.get(i - 1).end);
            int rm = now.start;
            if (lm < newInterval.start && rm > newInterval.end) {
                intervals.add(i, newInterval);
                return intervals;
            }
        }
        // 有重叠
        if (merge != null) {
            intervals.remove(i);
        } else {
            if (i == intervals.size()) {
                intervals.add(newInterval);
            }
        }
        // // todo:可以优化，因为会重复查找....
        return insert(intervals, merge);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            int n = sc.nextInt();
            sc.nextLine();
            List<Interval> intervals = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                intervals.add(new Interval(sc.nextInt(), sc.nextInt()));
            }
            Interval newInterval = new Interval(sc.nextInt(), sc.nextInt());
            for (Interval var : s.insert(intervals, newInterval)) {
                System.out.println(var);
            }
        }
    }
}

// Input>>>
// 1
// 2 4
// 1 5
// [1,5]
// Input>>>
// 1
// 2 4
// 1 3
// [1,4]
// Input>>>
// 1
// 2 4
// 3 5
// [2,5]
// Input>>>
// 1
// 2 4
// 1 8
// [1,8]
// Input>>>
// 1
// 2 4
// 5 6
// [2,4]
// [5,6]
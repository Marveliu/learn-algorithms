import java.util.*;

// 56. Merge Intervals
// 思路：归并排序
public class Solution {

    public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        if (len <= 1)
            return intervals;
        int mid = len / 2;
        List<Interval> lefts = merge(new ArrayList<>(intervals.subList(0, mid)));
        List<Interval> rights = merge(new ArrayList<>(intervals.subList(mid, len)));
        List<Interval> sort = new ArrayList<>();
        int l = 0;
        int r = 0;
        while (l < lefts.size() && r < rights.size()) {
            Interval left = lefts.get(l);
            Interval right = rights.get(r);
            // 重叠
            if ((left.start >= right.start && left.start <= right.end)
                    || (left.end >= right.start && left.end <= right.end)
                    || (left.start < right.start && left.end > right.end)) {
                int start = Math.min(left.start, right.start);
                int end = Math.max(left.end, right.end);
                Interval merge = new Interval(start, end);
                add(sort, merge);
                l++;
                r++;
            } else {
                if (left.start < right.start) {
                    l++;
                    add(sort, left);
                } else {
                    r++;
                    add(sort, right);
                }
            }
        }
        int i = (l < lefts.size()) ? l : r;
        List<Interval> rem = (l < lefts.size()) ? lefts : rights;
        for (; i < rem.size(); i++) {
            add(sort, rem.get(i));
        }
        return sort;
    }

    public void add(List<Interval> intervals, Interval newInterval) {
        if (!intervals.isEmpty()) {
            Interval now = intervals.get(intervals.size() - 1);
            if ((now.start >= newInterval.start && now.start <= newInterval.end)
                    || (now.end >= newInterval.start && now.end <= newInterval.end)
                    || (now.start < newInterval.start && now.end > newInterval.end)) {
                int start = Math.min(now.start, newInterval.start);
                int end = Math.max(now.end, newInterval.end);
                now.start = start;
                now.end = end;
                return;
            }
        }
        intervals.add(newInterval);
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
            for (Interval var : s.merge(intervals)) {
                System.out.println(var);
            }
        }
    }
}

// i = 1
// [1,4],[4,5]
// i = 1
// [1,4],[4,5],[1,5]

// [[2,3],[5,5],[2,2],[3,4],[3,4]]
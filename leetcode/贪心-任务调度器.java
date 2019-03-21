import java.util.*;

/**
 * 621. Task Scheduler
 * 
 * https://www.youtube.com/watch?v=YCD_iYxyXoo
 * 
 * 贪心
 * 
 * 主要分为两类：
 * 1. n间隔存在idle，对出现频率最多的字符分成块，余下的补一些零碎
 * 2. n间隔不存在idle，即区间比较小，这样就是tasks.length
 */
public class Solution {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int i = 25;
        while (i >= 0 && count[i] == count[25]) {
            i--;
        }
        return Math.max(tasks.length, (count[25] - 1) * (n + 1) + 25 - i);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            System.out.println(s.leastInterval(sc.nextLine().toCharArray(), sc.nextInt()));
        }
    }
}
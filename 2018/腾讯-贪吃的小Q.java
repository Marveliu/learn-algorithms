import java.util.*;

/**
 * 贪吃的小Q
 * https://www.nowcoder.com/questionTerminal/d732267e73ce4918b61d9e3d0ddd9182
 * 
 * 小Q的父母要出差N天，走之前给小Q留下了M块巧克力。小Q决定每天吃的巧克力数量不少于前一天吃的一半，但是他又不想在父母回来之前的某一天没有巧克力吃，请问他第一天最多能吃多少块巧克力 
 * 
 * 思路：二分查找，dfs就凉了
 */
public class Main {

    static int days = 0;
    static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        days = sc.nextInt();
        total = sc.nextInt();
        if (days == 1) {
            System.out.println(total);
            return;
        }
        int low = 1;
        int high = total;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            int sum = sum(mid);
            if (sum > total) {
                high = mid - 1;
            } else if (sum < total) {
                low = mid + 1;
            } else {
                high = mid;
                break;
            }
        }
        System.out.println(high);
    }

    static int sum(int mid) {
        int sum = 0;
        for (int i = 0; i < days; i++) {
            sum += mid;
            mid = (int) Math.ceil((double) mid / 2);
        }
        return sum;
    }
}
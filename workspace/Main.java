import java.util.*;

public class Main {

    static void solve(int n, char c) {
        int count = 1;
        int t = 1;
        while (count <= n) {
            t += 2;
            count += t * 2;
        }
        count -= t * 2;
        t -= 2;
        int tmp = t;
        boolean flag = true;
        do {
            log(t, tmp, c);
            if (flag) {
                tmp -= 2;
            } else {
                tmp += 2;
            }
            if (tmp == 1)
                flag = false;
        } while (tmp <= t);
        System.out.println(n - count);
    }

    static void log(int t, int n, char c) {
        int spaces = t - n;
        while (spaces > 0) {
            System.out.print(" ");
            spaces--;
        }
        while (n > 1) {
            System.out.print(c + " ");
            n--;
        }
        System.out.println(c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            char c = sc.nextLine().toCharArray()[1];
            solve(n, c);
        }
    }
}

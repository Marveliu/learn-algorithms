import java.util.Arrays;
import java.util.List;

class LogUtil {

    public static void log() {
        System.out.println("hello world!");
    }

    public static void log(int t) {
        System.out.println(t);
    }

    public static void log(int[] s) {
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        LogUtil.log();
    }

    public static void main(List<Integer> args) {
        for (int i = 0; i < args.size(); i++) {
            System.out.println(args.get(i));
        }
    }

}
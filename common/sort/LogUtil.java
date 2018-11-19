import java.util.Arrays;

class LogUtil {

    public static void log() {
        System.out.println("hello world!");
    }

    public static void log(int[] s) {
        // 格式化输出数组
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        LogUtil.log();
    }

}

// 字符串工具类，仅用于测试
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringUtil {

    // public static String p =
    // "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";

    // 过滤特殊字符 # , 不过滤
    public static String p = "[\"\\]\\[@]";

    public static String StringFilter(String str) {
        try {
            // 只允许字母和数字        
            // String regEx = "[^a-zA-Z0-9]";
            // 清除掉所有特殊字符   
            String regEx = p;
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            return m.replaceAll("").trim();
        } catch (Exception e) {
            System.out.println("字符串过滤出错");
        }
        return "";
    }

    public static String nextLineFilter(Scanner sc) {
        return StringFilter(sc.nextLine());
    }

    public static int[] getIntArr(Scanner sc) {
        return Arrays.asList(nextLineFilter(sc).split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
    }

}
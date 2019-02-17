import java.util.Stack;

/**
 * 替换空格
 * 字符串
 * 
 * https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13
 */
public class Solution {

    // StringBuilder
    // public String replaceSpace(StringBuffer str) {
    // StringBuilder sb = new StringBuilder();
    // String r = "%20";
    // for (int i = 0; i < str.length(); i++) {
    // if (str.charAt(i) == ' ') {
    // sb.append(r);
    // } else {
    // sb.append(str.charAt(i));
    // }
    // }
    // ;
    // return sb.toString();
    // }

    // 栈存放空格出现的地址
    // 扩展stringbuffer，从后往前遍历，赋值并且替换空格
    public String replaceSpace(StringBuffer str) {
        int origin = str.length();
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < origin; i++) {
            if (str.charAt(i) == ' ') {
                s.push(i);
            }
        }
        // % 2 0 count 3
        int n = origin + s.size() * 2;
        str.setLength(n);
        int p0 = origin - 1;
        int p1 = n - 1;
        while (p0 >= 0) {
            if (s.size() == 0) {
                break;
            } else if (s.peek() == p0) {
                str.setCharAt(p1--, '0');
                str.setCharAt(p1--, '2');
                str.setCharAt(p1--, '%');
                s.pop();
            } else {
                str.setCharAt(p1--, str.charAt(p0));
            }
            p0--;
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        StringBuffer str = new StringBuffer("we are happy");
        System.out.println(s.replaceSpace(str));

        // unmappable character for encoding ASCII
        // char test = '20';
        // System.out.println(test);
    }
}
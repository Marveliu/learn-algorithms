import java.util.Stack;

// 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
// 1: 开一个额外的空间，遍历。
// 2: 使用现有的stringbuffer, 遍历获得空格个数存入栈之中，扩展其空间大小之后，从后往前填入值，本质上，减少元素移动的次数。

public class Solution {

    // public String replaceSpace(StringBuffer str) {
    // StringBuffer tmp = new StringBuffer();
    // String r = "%20";
    // for (int i = 0; i < str.length(); i++) {
    // if (str.charAt(i) == ' ') {
    // tmp.append(r);
    // } else {
    // tmp.append(str.charAt(i));
    // }
    // }

    // str = tmp;
    // return tmp.toString();
    // }

    // smallest extra space
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
            // todo : NPE
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
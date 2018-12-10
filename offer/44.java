import java.util.*;
// 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么
public class Solution {

    public String ReverseSentence(String str) {
        if (str == null || str.isEmpty() || str.split(" ").length == 0) {
            return str;
        }
        String[] cs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = cs.length - 1; i > 0; i--) {
            sb.append(cs[i]);
            sb.append(" ");
        }
        return sb.append(cs[0]).toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            String ans = s.ReverseSentence(in);
            System.out.println(ans);
        }
    }
}
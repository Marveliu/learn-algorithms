import java.util.*;

// 43. Multiply Strings
// https://leetcode.windliang.cc/leetCode-43-Multiply-Strings.html
// 竖式计算
public class Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] pos = new int[n1 + n2]; //保存最后的结果
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                //相乘的结果
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                //加上 pos[i+j+1] 之前已经累加的结果
                int sum = mul + pos[i + j + 1];
                //更新 pos[i + j]
                pos[i + j] += sum / 10;
                //更新 pos[i + j + 1]
                pos[i + j + 1] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos.length; i++) {
            //判断最高位是不是 0 
            if (i == 0 && pos[i] == 0) {
                continue;
            }
            sb.append(pos[i]);
        }
        return sb.toString();
    }
    

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
        }
    }
}
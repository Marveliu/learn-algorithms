import java.util.*;
import java.util.stream.Collectors;

// LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
// 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
// “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
// 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
// LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。

// 此类型的题，关键是从中找出规律，模拟只是最后的办法
public class Solution {

    // 1. 模拟实际比较的过程
    // public boolean isContinuous(int[] numbers) {
    // if (numbers.length == 0)
    // return false;
    // int min = Integer.MAX_VALUE;
    // int n = 0;
    // for (int var : numbers) {
    // if (var != 0) {
    // if (var < min)
    // min = var;
    // } else {
    // n++;
    // }
    // }
    // int p = min;
    // List<Integer> nums =
    // Arrays.stream(numbers).boxed().collect(Collectors.toList());
    // while (p <= min + numbers.length - 1) {
    // if (!nums.contains(p)) {
    // if (n != 0) {
    // n--;
    // } else {
    // return false;
    // }
    // }
    // p++;
    // }
    // return true;
    // }

    // 2.找规律
    // 1、排序 
    // 2、计算所有相邻数字间隔总数 
    // 3、计算0的个数 
    // 4、如果2、3相等，就是顺子 
    // 5、如果出现对子，则不是顺子
    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        int any = 0;
        int n = 0;
        for (; numbers[any] == 0; any++) {
        }
        for (int i = any + 1; i < numbers.length; i++) {
            if (numbers[i - 1] == numbers[i])
                return false;
            n += numbers[i] - numbers[i - 1] - 1;
        }
        return any >= n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String in = sc.nextLine();
            int[] test = Arrays.asList(in.split(",")).stream().mapToInt(item -> Integer.valueOf(item)).toArray();
            Boolean res = s.isContinuous(test);
            System.out.println(res);
        }
    }
}
import java.util.*;


/**
 * 292. Nim Game
 * https://leetcode.com/problems/nim-game/
 * 
 * 每次只能取1-3个石子，拿到最后的石子的人胜利
 * 某人先拿，石头总数为n，能否胜利
 * 
 * 1    Win
 * 2    Win
 * 3    Win
 * 4    Lost
 * 5    Win
 * 6    Win
 * 7    Win
 * 8    Lost
 * 9    Win
 * 10   Win
 * 
 */
public class Solution {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
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
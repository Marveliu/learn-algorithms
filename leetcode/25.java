import java.util.*;


// 127. Word Ladder
// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.


// BFS进行图遍历
// 思路:双端bfs
public class Solution {

    // 双端BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null)
            return 0;
        if (beginWord.length() == 0 && endWord.length() == 0)
            return 0;
        if (wordList == null || wordList.size() == 0)
            return 0;
        int dist = 0;
        Set<String> visit = new HashSet<>();
        Set<String> dict = new HashSet<>();
        for (String var : wordList) {
            dict.add(var);
        }
        if(!dict.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        visit.add(beginWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tmp = endSet;
                endSet = beginSet;
                beginSet = tmp;
            }
            System.out.println("b:" + Arrays.toString(beginSet.toArray()));
            System.out.println("e:" + Arrays.toString(endSet.toArray()));
            Set<String> tmp = new HashSet<>();
            for (String var : beginSet) {
                for (String word : getWords(var, dict)) {
                    if (endSet.contains(word)) {
                        return dist + 2;
                    }
                    if (!visit.contains(word)) {
                        visit.add(word);
                        tmp.add(word);
                    }
                }
            }
            beginSet = tmp;
            dist++;
        }
        return 0;
    }

    public List<String> getWords(String s, Set<String> wordList) {
        List<String> arr = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char[] cs = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != cs[i]) {
                    cs[i] = c;
                    String tmp = new String(cs);
                    if (wordList.contains(tmp)) {
                        arr.add(tmp);
                    }
                }
            }
        }
        return arr;
    }

    // bfs
    // public int ladderLength(String beginWord, String endWord, List<String>
    // wordList) {
    // if (beginWord == null || endWord == null)
    // return 0;
    // if (beginWord.length() == 0 && endWord.length() == 0)
    // return 0;
    // if (wordList == null || wordList.size() == 0)
    // return 0;
    // int dist = 0;
    // ArrayDeque<String> qDeque = new ArrayDeque<>();
    // qDeque.add(beginWord);
    // Set<String> visit = new HashSet();
    // Set<String> dict = new HashSet<>();
    // for (String var : wordList) {
    // dict.add(var);
    // }
    // visit.add(beginWord);
    // while (!qDeque.isEmpty()) {
    // ArrayDeque<String> tmp = new ArrayDeque<>();
    // while (!qDeque.isEmpty()) {
    // String u = qDeque.pollFirst();
    // List<String> ls = getWords(u, visit, dict);
    // for (String var : ls) {
    // if (var.equals(endWord)) {
    // return dist + 2;
    // }
    // visit.add(var);
    // tmp.add(var);
    // }
    // }
    // dist++;
    // qDeque = tmp;
    // }
    // return 0;
    // }

    // public List<String> getWords(String s, Set<String> visit, Set<String>
    // wordList) {
    // List<String> arr = new ArrayList<>();
    // int len = s.length();
    // for (int i = 0; i < len; i++) {
    // char[] cs = s.toCharArray();
    // for (char c = 'a'; c <= 'z'; c++) {
    // if (c != cs[i]) {
    // cs[i] = c;
    // String tmp = new String(cs);
    // if (wordList.contains(tmp) && !visit.contains(tmp)) {
    // arr.add(tmp);
    // }
    // }
    // }
    // }
    // return arr;
    // }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String beginWord = StringUtil.nextLineFilter(sc);
            String endWord = StringUtil.nextLineFilter(sc);
            List<String> wordList = Arrays.asList(StringUtil.nextLineFilter(sc).split(","));
            int ans = s.ladderLength(beginWord, endWord, wordList);
            System.out.println(ans);
        }
    }
}

// "hot"
// "dog"
// ["hot","dog"]

// "hit"
// "cog"
// ["hot","dot","dog","lot","log"]

// "hit"
// "cog"
// ["hot","dot","dog","lot","log","cog"]

// hit
// cog
// hot,cog
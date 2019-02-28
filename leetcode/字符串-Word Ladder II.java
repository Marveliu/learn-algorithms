import java.util.*;

// 126. Word Ladder II
// Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
// Only one letter can be changed at a time
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

// todo:可以用双端BFS进行优化

/**
 * 126. Word Ladder II
 * 
 * 
 */
public class Solution {

    // dijkstra算法 
    // vp记录前缀序列
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<List<String>>> vp = new HashMap<>();
        Set<String> visit = new HashSet<>();
        Set<String> queue = new HashSet<>();
        Set<String> dict = new HashSet<>();
        for (String var : wordList) {
            dict.add(var);
        }
        queue.add(beginWord);
        List<List<String>> arr = new ArrayList<>();
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        arr.add(ls);
        vp.put(beginWord, arr);
        boolean flag = false;
        int dist = 1;
        while (!queue.isEmpty() && !flag) {
            Set<String> tmp = new HashSet<>();
            for (String s : queue) {
                if (visit.contains(s)) {
                    continue;
                }
                visit.add(s);
                List<List<String>> opaths = vp.get(s);
                for (String var : getWords(s, visit, dict)) {
                    if (var.equals(endWord)) {
                        flag = true;
                    }
                    tmp.add(var);
                    List<List<String>> npaths = null;
                    if (vp.containsKey(var)) {
                        npaths = vp.get(var);
                    } else {
                        npaths = new ArrayList<>();
                    }
                    for (List<String> path : opaths) {
                        if (path.size() <= dist) {
                            List<String> npath = new ArrayList<>(path);
                            npath.add(var);
                            npaths.add(npath);
                        }
                    }
                    vp.put(var, npaths);
                }
            }
            dist++;
            queue = tmp;
        }
        if (flag)
            return vp.get(endWord);
        // return Collections.EMPTY_LIST;
        return new ArrayList<>();
    }

    public List<String> getWords(String s, Set<String> visit, Set<String> wordList) {
        List<String> arr = new ArrayList<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char[] cs = s.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != cs[i]) {
                    cs[i] = c;
                    String tmp = new String(cs);
                    if (wordList.contains(tmp) && !visit.contains(tmp)) {
                        arr.add(tmp);
                    }
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input>>>");
            String beginWord = StringUtil.nextLineFilter(sc);
            String endWord = StringUtil.nextLineFilter(sc);
            List<String> wordList = Arrays.asList(StringUtil.nextLineFilter(sc).split(","));
            List<List<String>> ans = s.findLadders(beginWord, endWord, wordList);
            for (List<String> var : ans) {
                System.out.println(Arrays.toString(var.toArray()));
            }
        }
    }
}

// "hit"
// "cog"
// ["hot","dot","dog","lot","log","cog"]

// "hit"
//
// ["hot","dot","dog","lot","log","cog"]
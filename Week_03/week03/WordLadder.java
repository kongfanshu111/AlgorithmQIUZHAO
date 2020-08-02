package week03;

import java.util.*;

/**
 * @Param: leetcode 127
 * @Author: fanshu.kong
 * @Date: 2020.08.02
 */

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.isEmpty() || !wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.remove();
                char[] ch = temp.toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    char pre = ch[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (pre == k) continue;
                        ch[j] = k;
                        String next = String.valueOf(ch);
                        if (wordSet.contains(next)) {
                            if (next.equals(endWord)) {
                                step++;
                                return step;
                            }
                            if (!visited.contains(next)) {
                                queue.add(next);
                                visited.add(next);
                            }
                        }
                    }
                    ch[j] = pre;
                }
            }
            step++;
        }
        return 0;
    }
}

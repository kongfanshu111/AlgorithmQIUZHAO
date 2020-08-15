package week05;

import java.util.*;

/**
 * @Param: leetcode 127
 * @Author: fanshu.kong
 * @Date: 2020.08.15
 */

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String s = queue.remove();
                char[] ch = s.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    char temp = ch[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (temp == j) continue;
                        ch[i] = j;
                        String newWord = String.valueOf(ch);
                        if (wordSet.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(newWord)) {
                                visited.add(newWord);
                                queue.add(newWord);
                            }
                        }
                    }
                    ch[i] = temp;
                }
            }
            step++;
        }
        return 0;
    }
}

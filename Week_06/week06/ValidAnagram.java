package week06;

import java.util.HashMap;
import java.util.Map;

/**
 * @Param: leetcode 242
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class ValidAnagram {
    // 使用数组作为map
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int j = 0; j < count.length; j++) {
            if (count[j] != 0)
                return false;
        }
        return true;
    }

    // 与方法一一样，使用map
    public boolean isAnagram01(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (map.containsKey(t.charAt(i)))
                map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
            else return false;
        }

        for (int each : map.values()) {
            if (each != 0) return false;
        }

        return true;
    }
}

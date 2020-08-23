package week06;

/**
 * @Param: leetcode 387
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++; // 注意转换为数组下标的做法
        }
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }
}
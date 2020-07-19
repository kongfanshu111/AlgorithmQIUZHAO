package week01;

import java.util.Arrays;

/**
 * @Param: leetcode 242
 * @Author: fanshu.kong
 * @Date: 2020.07.19
 */

public class ValidAnagram {

    /**
     * 分别对字符串排序，然后比较
     * 时间复杂度O(nlogn)
     * 空间复杂度O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram01(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1,ch2);
    }

    /**
     * 使用一个map来记录每个字符出现的个数，
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram02(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i =0; i < s.length(); i++) {
            count[s.charAt(i) - 'a'] ++;
            count[t.charAt(i) - 'a'] --;
        }
        for (int n : count) {
            if (n != 0) return false;
        }
        return true;
    }
}

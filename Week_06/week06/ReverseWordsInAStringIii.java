package week06;

/**
 * @Param: leetcode 557
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class ReverseWordsInAStringIii {

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        int j = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            while (i < s.length() && s.charAt(i) != ' ') i++;
            reverse(j, i - 1, ch);
            j = i + 1;
        }
        return String.valueOf(ch);
    }

    public void reverse(int start, int end, char[] ch) {
        while (start < end) {
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
    }
}

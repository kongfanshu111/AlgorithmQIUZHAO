package week06;

/**
 * @Param: leetcode 151
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        int j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') i--;
            sb.append(s.substring(i + 1, j + 1) + " "); // 注意考虑这里的边界
            while (i >= 0 && s.charAt(i) == ' ') i--;
            j = i;
        }
        return sb.toString().trim();
    }
}

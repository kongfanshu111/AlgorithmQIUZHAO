package week06;

/**
 * @Param: leetcode 917
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) return S;
        int len = S.length();
        int i = 0;
        int j = len - 1;
        char[] ch = S.toCharArray();
        while (i < j) {
            while (i < j && !Character.isLetter(ch[i])) i++;
            if (i >= j) break;
            char temp = ch[i];
            while (i < j && !Character.isLetter(ch[j])) j--;
            if (i >= j) break;
            ch[i++] = ch[j];
            ch[j--] = temp;
        }
        return String.valueOf(ch);
    }
}

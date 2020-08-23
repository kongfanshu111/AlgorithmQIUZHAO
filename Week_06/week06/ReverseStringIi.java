package week06;

/**
 * @Param: leetcode 541
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class ReverseStringIi {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) { // 注意这里的2k，每次都忘记乘号*
            int start = i;
            int end = Math.min(i + k - 1, s.length() - 1);
            reverse(start, end, ch);
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

package week04;

/**
 * @Param: leetcode 32
 * @Author: fanshu.kong
 * @Date: 2020.08.09
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len == 0)
            return 0;
        int[] flag = new int[len];
        flag[0] = 0;
        for(int i = 1; i < len; i++) {
            if(s.charAt(i) == '(')
                flag[i] = 0;
            else if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == '(') {
                    if(i - 2 >= 0)
                        flag[i] = flag[i - 2] + 2;
                    else
                        flag[i] = 2;
                } else if (s.charAt(i - 1) == ')') {
                    if(i - flag[i - 1] - 1 >= 0 && s.charAt(i - flag[i - 1] - 1) =='(')
                        flag[i] = i - flag[i - 1] - 2 >= 0 ? flag[i - 1] + 2 + flag[i - flag[i - 1] - 2] : flag[i - 1] + 2;
                }
            }
        }
        int max = 0;
        for(int i = len - 1; i >= 0; i--) {
            if(flag[i] > max)
                max = flag[i];
        }
        return max;
    }
}

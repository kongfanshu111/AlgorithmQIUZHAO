package week06;

/**
 * @Param: leetcode 91
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class DecodeWays {
    // 子问题：f(i) = f(i - 1) + f(i - 2)
    // 状态定义：dp[i]表示前i+1的字符的解码方法
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') dp[i] = dp[i - 1];
            int num = 10 * (s.charAt(i - 1) - '0') + s.charAt(i) - '0';
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i] ++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length() - 1];
    }
}

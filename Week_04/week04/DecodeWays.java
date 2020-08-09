package week04;

/**
 * @Param: leetcode 91
 * @Author: fanshu.kong
 * @Date: 2020.08.09
 */

public class DecodeWays {
    public int numDecodings(String s) {
        char[] arr = s.toCharArray();
        int n = s.length();
        if (arr[0] == '0') return 0;
        int[] res = new int[arr.length];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] != '0') {
                res[i] = res[i - 1];
            }
            int num = Integer.valueOf(s.substring(i - 1, i+1));
            //int num = 10 * (arr[i - 1] - '0') + (arr[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    res[i]++;
                } else {
                    res[i] += res[i - 2];
                }
            }
        }
        return res[n - 1];
    }
}

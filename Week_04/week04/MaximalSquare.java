package week04;

/**
 * @Param: leetcode 221
 * @Author: fanshu.kong
 * @Date: 2020.08.09
 */

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        int[][] dp = new int[m + 1][n + 1]; // 注意初始条件的处理
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j],Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    max = Math.max(max, dp[i + 1][j + 1]);
                }
            }
        }
        return max * max;
    }
}

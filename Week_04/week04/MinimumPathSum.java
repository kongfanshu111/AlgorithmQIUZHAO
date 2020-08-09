package week04;

/**
 * @Param: leetcode 64
 * @Author: fanshu.kong
 * @Date: 2020.08.09
 */

public class MinimumPathSum {
    // f[i][j] = min(f[i - 1][j], f[i][j - 1]) + n[i][j]
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] arr = new int[m][n];
        arr[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            arr[i][0] = arr[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            arr[0][i] = arr[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = Math.min(arr[i- 1][j],arr[i][j - 1]) + grid[i][j];
            }
        }
        return arr[m - 1][n - 1];
    }
}

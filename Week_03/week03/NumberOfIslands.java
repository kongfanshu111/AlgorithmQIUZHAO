package week03;

/**
 * @Param: leetcode 200
 * @Author: fanshu.kong
 * @Date: 2020.08.01
 */

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        if (grid.length == 0) return count;
        if (grid[0].length == 0) return count;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    helper(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void helper(int i, int j, char[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return ;
        grid[i][j] = '0';
        helper(i - 1, j, grid);
        helper(i, j - 1, grid);
        helper(i + 1, j, grid);
        helper(i, j + 1, grid);
    }
}

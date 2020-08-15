package week05;

/**
 * @Param: leetcode 200
 * @Author: fanshu.kong
 * @Date: 2020.08.15
 */

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(i , j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
            return ;
        else
            grid[row][col] = '0';
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col - 1, grid);
        dfs(row, col + 1, grid);
    }
}

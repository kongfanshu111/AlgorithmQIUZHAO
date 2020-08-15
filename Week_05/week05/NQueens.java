package week05;

import java.util.ArrayList;
import java.util.List;

/**
 * @Param: leetcode 51
 * @Author: fanshu.kong
 * @Date: 2020.08.14
 */

public class NQueens {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return res;
        char[][] dp = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = '.';
            }
        }
        nQueens(0,n,dp);
        return res;
    }

    public void nQueens(int row, int n,char[][] dp) {
        if (row == n) {
            out(dp);
            return ;
        }
        for (int i = 0; i < n; i++) {
            dp[row][i] = 'Q';
            if (check(row, i, dp)) {
                nQueens(row + 1, n, dp);
            }
            dp[row][i] = '.';
        }
    }

//    public boolean check(int row, int col, char[][] dp) {
//        int leftUp = col - 1;
//        int rightUp = col + 1;
//        for (int i = row - 1; i >= 0; i--) {
//            if (dp[i][col] == 'Q') return false;
//            if (leftUp >= 0 && dp[i][leftUp] == 'Q') return false;
//            if (rightUp < dp.length && dp[i][rightUp] == 'Q') return false;
//            leftUp --;
//            rightUp ++;
//        }
//        return true;
//    }

    // 使用竖撇捺进行确认是否被攻击
    public  boolean check(int row, int col, char[][] dp) {
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < dp.length; j++) {
                if (dp[i][j] == 'Q' && (col + row == i + j || col - row == j - i || col == j))
                    return false;
            }
        }
        return true;
    }

    public void out(char[][] dp) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < dp.length; j++) {
                sb.append(dp[i][j]);
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}

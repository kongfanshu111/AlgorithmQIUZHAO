package week05;

/**
 * @Param: leetcode 70
 * @Author: fanshu.kong
 * @Date: 2020.08.14
 */

public class ClimbingStairs {
    // 递归 + 记忆化搜索
    public int climbStairs01(int n) {
        int[] arr = new int[n + 1];
        return dfs(n, arr);
    }
    public int dfs(int n, int[] arr) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (arr[n] != 0) return arr[n];
        else return arr[n] = dfs(n - 1, arr) + dfs(n - 2, arr);
    }

    // dp方程 f(n) = f(n - 1) + f(n - 2)
    public int climbStairs02(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++) {
            int temp = pre + cur;
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}

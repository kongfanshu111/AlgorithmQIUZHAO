package week04;

/**
 * @Param: leetcode 72
 * @Author: fanshu.kong
 * @Date: 2020.08.09
 */

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null)
            return 0;
        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();
        int[][] flag = new int[a.length+1][b.length + 1];
        flag[0][0] = 0;
        for(int j = 1; j < b.length + 1; j++) {
            flag[0][j] = j;
        }
        for(int i = 1; i < a.length + 1; i++) {
            flag[i][0] = i;
        }
        for(int i = 1; i < a.length + 1; i++) {
            for(int j = 1; j < b.length + 1; j++) {
                if(a[i - 1] == b[j - 1]) {
                    flag[i][j] = flag[i - 1][j - 1];
                } else {
                    flag[i][j] = min_len(flag[i - 1][j] + 1, flag[i][j - 1] + 1, flag[i - 1][j - 1] + 1);
                }
            }
        }
        return flag[a.length][b.length];
    }

    public int min_len(int x, int y, int z) {
        int min = Integer.MAX_VALUE;
        if(min > x) min = x;
        if(min > y) min = y;
        if(min > z) min = z;
        return min;
    }
}

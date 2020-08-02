package week03;

/**
 * @Param: leetcode 74
 * @Author: fanshu.kong
 * @Date: 2020.08.02
 */

public class SearchA2dMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int m = matrix.length;
        if (matrix[0].length == 0) return false;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            int temp = matrix[mid / n][mid % n];
            if (target == temp) return true;
            else if (target > temp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

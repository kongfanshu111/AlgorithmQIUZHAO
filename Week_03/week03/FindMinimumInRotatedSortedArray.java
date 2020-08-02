package week03;

/**
 * @Param: leetcode 153
 * @Author: fanshu.kong
 * @Date: 2020.08.02
 */

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] <= nums[right]) return nums[0];
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

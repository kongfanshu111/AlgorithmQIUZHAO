package week03;

/**
 * @Param: leetcode 33
 * @Author: fanshu.kong
 * @Date: 2020.08.02
 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}

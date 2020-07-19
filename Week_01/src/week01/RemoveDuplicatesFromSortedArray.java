package week01;

/**
 * @Param: leetcode 26
 * @Author: fanshu.Kong
 * @Date: 2020.07.18
 */

public class RemoveDuplicatesFromSortedArray {

    /**
     * 方法1，利用三数之和中去除重复元素的方法
     * @param nums
     * @return
     */
    public int removeDuplicates01(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[j++] = nums[i];
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return j;
    }

    /**
     * 双指针法，快慢指针，比较两个是否相同，相同则快指针继续往前走
     * @param nums
     * @return
     */
    public int removeDuplicates02(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}

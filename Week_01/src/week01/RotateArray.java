package week01;

/**
 * @Param: leetcode 189
 * @Author: fanshu.kong
 * @Date: 2020.07.19
 */

public class RotateArray {

    /**
     * 暴力法，每次将数组依次往后移动一个位置，移动k次
     * @param nums
     * @param k
     */
    public void rotate01(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int tail = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = tail;
                tail = temp;
            }
        }
    }


    /**
     * 方法二，三次旋转
     * @param nums
     * @param k
     */
    public void rotate02(int[] nums, int k) {
        k  %= nums.length;  // 注意这里k的处理
        reverse(nums, 0 ,nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}

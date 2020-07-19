package week01;

import java.util.Arrays;

/**
 * @Param: leetcode 283
 * @Author: fanshu.Kong
 * @Date: 2020.07.18
 */

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,3,12};
        MoveZeroes moveZeroes = new MoveZeroes();
        nums = moveZeroes.moveZeroes03(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 方法一，依次不为零的元素添加到应在的位置，后面的位置归零
     * @param nums
     * @return
     */
    public int[] moveZeroes01(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (; j < nums.length; j++) {
            nums[j] = 0;
        }
        return nums;
    }

    /**
     * 方法二，在加到应在的位置的同时将此元素置零
     * @param nums
     * @return
     */
    public int[] moveZeroes02(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j)
                    nums[i] = 0;
                j++;
            }
        }
        return nums;
    }

    public int[] moveZeroes03(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return nums;
    }

}

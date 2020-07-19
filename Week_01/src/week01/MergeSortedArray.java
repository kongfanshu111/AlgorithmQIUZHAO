package week01;

/**
 * @Param: leetcode 88
 * @Author: fanshu.kong
 * @Date: 2020.07.19
 */

public class MergeSortedArray {

    /**
     * 暴力法，新建一个数组，两个数组比较，将元素放入新数组中，最后再复制到 nums1
     * 数组中去,时间复杂度O(m + n),空间（m + n）
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge01(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] nums3 = new int[m + n];
        while (i < m && j < n) {
            int num = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
            nums3[k++] = num;
        }
        while (i < m) {
            nums3[k++] = nums1[i++];
        }
        while (j < n) {
            nums3[k++] = nums2[j++];
        }
        for (int l = 0; l < nums3.length; l++) {
            nums1[l] = nums3[l];
        }
    }

    /**
     * 双指针从后往前来比较排序，可以减少空间复杂度
     * 时间复杂度O(m + n)
     * 空间复杂度O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge02(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}


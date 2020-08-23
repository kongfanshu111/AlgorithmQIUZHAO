package week06;

/**
 * @Param: leetcode 1122
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001]; // 把元素的值当做下标，数组的值是频次
        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]]++;
        }
        int index = 0;
        for (int j = 0; j < arr2.length; j++) {
            while (count[arr2[j]] != 0) {
                arr1[index++] = arr2[j];
                count[arr2[j]]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        return arr1;
    }
}

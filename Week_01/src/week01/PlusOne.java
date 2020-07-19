package week01;

/**
 * @Param: leetcode 66
 * @Author: fanshu.kong
 * @Date: 2020.07.19
 */

public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return null;
        int flag = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + flag;
            flag = sum / 10;
            digits[i] = sum % 10;
        }
        if (flag == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return  res;
        }
        return digits;
    }
}

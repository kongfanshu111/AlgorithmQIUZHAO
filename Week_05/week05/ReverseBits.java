package week05;

/**
 * @Param: leetcode 190
 * @Author: fanshu.kong
 * @Date: 2020.08.14
 */

public class ReverseBits {
    public int reverseBits(int n) {
        int temp = 0;
        for (int i = 0; i < 32; i++) {
            temp = (temp << 1) + (n & 1);
            n = (n >>> 1);
        }
        return temp;
    }
}

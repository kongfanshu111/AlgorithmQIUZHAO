package week05;

/**
 * @Param: leetcode 191
 * @Author: fanshu.kong
 * @Date: 2020.08.14
 */

public class NumberOf1Bits {
    // x & (x - 1)清除最低位的1
    public int hammingWeight01(int n) {
        int count = 0;
        while (n != 0) {
            n = (n & (n - 1));
            count++;
        }
        return count;
    }

    public int hammingWeight02(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n = (n >>> 1); // 注意Java中没有无符号整数，使用>>>无符号右移,使用for循环>>也可以
        }
        return count;
    }

}

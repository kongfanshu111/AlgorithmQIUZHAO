package week05;

/**
 * @Param: leetcode 231
 * @Author: fanshu.kong
 * @Date: 2020.08.14
 */

public class PowerOfTwo {

    public boolean isPowerOfTwo01(int n) {
        if (n <= 0) return false;
        if ((n & (n -1)) == 0) return true;
        else return false;
    }

    public boolean isPowerOfTwo02(int n) {
        if (n <= 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }
}

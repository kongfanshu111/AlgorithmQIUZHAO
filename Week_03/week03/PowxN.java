package week03;

/**
 * @Param: leetcode 50
 * @Author: fanshu.kong
 * @Date: 2020.08.01
 */

public class PowxN {
    // 使用分治进行递归
    public double myPow(double x, int n) {
        double res = n >= 0 ? pow(x,n) : 1 / pow(x, -n);
        return res;
    }

    public double pow(double x, int n) {
        if (n == 0) return 1.0;
        double number = pow(x, n / 2);
        return n % 2 == 0 ? number * number : number * number * x;
    }
}

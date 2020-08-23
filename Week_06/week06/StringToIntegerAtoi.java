package week06;

/**
 * @Param: leetcode 8
 * @Author: fanshu.kong
 * @Date: 2020.08.23
 */

public class StringToIntegerAtoi {

    public int myAtoi(String str) {
        int index = 0,sign = 1,total = 0;
        if (str == null || str.length() == 0) return 0;

        // 处理空格
        while (index < str.length() && str.charAt(index) == ' ') index++;
        if (index >= str.length()) return 0;

        // 处理符号
        if (index < str.length() && str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        // 处理数字
        while (index < str.length()) {
            int num = str.charAt(index) - '0';
            if (num < 0 || num > 9) break;

            if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < num)
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            total = total * 10 + num;
            index++;
        }
        return total * sign;
    }
}

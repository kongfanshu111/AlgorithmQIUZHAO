package week03;

/**
 * @Param: leetcode 860
 * @Author: fanshu.kong
 * @Date: 2050.08.01
 */

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        if (bills[0] > 5) return false;
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                if (five > 0)
                    five --;
                else
                    return false;
            } else {
                if (five > 0 && ten > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else
                    return false;
            }
        }
        return true;
    }
}

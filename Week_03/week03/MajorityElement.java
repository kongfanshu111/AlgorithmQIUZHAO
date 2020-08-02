package week03;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Param: leetcode 169
 * @Author: fanshu.kong
 * @Date: 2020.08.01
 */

public class MajorityElement {

    // 使用map存储key出现的次数，最后遍历map的value与n/2比较
    public int majorityElement01(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i]) + 1);
            else
                map.put(nums[i],1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2)
                return entry.getKey();
        }
        return 0;
    }

    // 直接对数组排序，中间值必为结果
    public int majorityElement02(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // 投票法
    public int majorityElement03(int[] nums) {
        int count = 1;
        int number = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (number == nums[i]) {
                count++;
            } else if (--count == 0) {
                number = nums[i];
                count = 1;
            }
        }
        return number;
    }

}

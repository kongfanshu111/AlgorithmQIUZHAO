package week03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Param: leetcode 78
 * @Author: fanshu.kong
 * @Date: 2020.08.01
 */

public class Subsets {
    // 回溯，按照括号生成的思想去考虑，一个个格子是放左括号还是右括号
    // 数组中的元素添加进来还是不添加，一样的思路
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) return res;
        helper(0,nums.length,nums,new ArrayList<>());
        return res;
    }
    public void helper(int index, int max, int[] nums,List<Integer> list) {
        // 递归终止条件
        if (index == max) {
            res.add(new ArrayList<>(list)); // 不传进new的会变为空
            return ;
        }
        // 处理当前层，添加还是不添加
        // drill down到下一层
        helper(index + 1, max, nums, list);
        list.add(nums[index]);
        helper(index + 1, max, nums, list);
        // 清除当前层状态
        list.remove(list.size() - 1);
    }
}

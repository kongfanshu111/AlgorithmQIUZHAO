package week03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Param: leetcode 17
 * @Author: fanshu.kong
 * @Date: 2020.08.01
 */

public class LetterCombinationsOfAPhoneNumber {
    List<String> list = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return list;
        Map<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8', "tuv");
        map.put('9',"wxyz");
        helper(0, digits, "",map);
        return list;
    }
    public void helper(int index, String digits, String str,Map<Character, String> map) {
        if (index == digits.length()) {
            list.add(str);
            return ;
        }
        String temp = map.get(digits.charAt(index));
        char[] ch = temp.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            String s = str + ch[i];
            helper(index + 1,digits,s,map);
        }
    }
}

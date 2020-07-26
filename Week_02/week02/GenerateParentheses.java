package week02;

import java.util.ArrayList;
import java.util.List;

/**
 * @Param: leetcode 22
 * @Author: fanshu.kong
 * @Date: 2020.07.26
 */

public class GenerateParentheses {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0,  0, n, "");
        return  res;
    }

    private void generate(int left, int right, int n, String s) {

        if (left == n && right == n) {
            res.add(s);
            return ;
        }

        if (left < n)   generate(left + 1, right, n, s + "(");
        if (left > right)   generate(left, right +1, n, s + ")");
    }

    public static void main(String[] args) {
        GenerateParentheses s = new GenerateParentheses();
        System.out.println(s.generateParenthesis(3));
    }
}

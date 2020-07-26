package week02;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Param: leetcode 144
 * @Author: fanshu.kong
 * @Date: 2020.07.26
 */

public class BinaryTreePreorderTraversal {
    // 递归
    public List<Integer> preorderTraversal01(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) return ;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

    // 使用栈模拟递归
    public List<Integer> preorderTraversal02(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) return list;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                stack.addLast(root);
                root = root.left;
            }
            root = stack.removeLast();
            root = root.right;
        }
        return list;
    }
}
